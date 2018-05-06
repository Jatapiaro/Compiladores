import java.sql.*;
import java.util.*;

public class SqlConnector {

    // Create a variable for the connection string.
    String connectionUrl;
    String databaseName = "escuela";
    // Declare the JDBC objects.
    Connection con = null;

    public SqlConnector() {
        try {
            this.connectionUrl = "jdbc:sqlserver://localhost:1433;" +
            "databaseName="+databaseName+";integratedSecurity=false;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl,"sa","compiladores@Bda10");
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public boolean executeQuery( Query q ) {
        switch (q.function) {

            case "simple":
                if ( !q.isQuery() ) {
                    return insertTuple(q);
                } else {
                    return makeQuery(q);
                }
            case "retract":
                return retractQuery(q);
            default:
                return false;

        }
    }

    //=====================================================================
    //
    //  Start of insert functions
    //
    //=====================================================================
    public boolean insertTuple( Query q ) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> columns = listOfColumns(q.table);
        List<String> primaryColumns = listOfPrimaryColumns(q.table);
        try {
            String query = insertQueryString(q, columns, primaryColumns);
            stmt = con.prepareStatement(query);
            int index = 1;
            for ( String value : q.values ) {
                if (isParsable(value)) {
                    stmt.setInt(index, Integer.parseInt(value));
                } else {
                    stmt.setString(index, value);
                }
                index++;
            }
            int affectedRows = stmt.executeUpdate();
            q.sqlQuery = query;
            q.function = "insert";
            List<String> result = new ArrayList<String>();
            result.add("Created or modified: "+affectedRows+" rows");
            q.setQueryResult(result);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }


    public String insertQueryString( Query q, List<String> columns, List<String> primaryColumns ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "MERGE INTO "+q.table+" AS t USING (SELECT " );
        StringBuilder putParams = new StringBuilder();
        for ( int i = 0; i<columns.size(); i++ ) {
            if ( i == columns.size()-1 ) {
                putParams.append(columns.get(i)+" = ? ) AS s ");
            } else {
                putParams.append(columns.get(i)+" = ?, ");
            }
        }
        sb.append(putParams.toString());
        StringBuilder keyColumns = new StringBuilder("ON ");
        for ( int i = 0; i<primaryColumns.size(); i++ ) {
            if ( i == primaryColumns.size()-1 ) {
                keyColumns.append("t."+primaryColumns.get(i)+" = s."+primaryColumns.get(i)+" ");
            } else {
                keyColumns.append("t."+primaryColumns.get(i)+" = s."+primaryColumns.get(i)+" AND ");
            }
        }
        sb.append(keyColumns.toString());
        sb.append("WHEN MATCHED THEN ");
        StringBuilder updateParameters = new StringBuilder("UPDATE SET ");
        for ( int i = 1; i<columns.size(); i++ ) {
            if ( i == columns.size()-1 ) {
                updateParameters.append(columns.get(i)+"=s."+columns.get(i)+" ");
            } else {
                updateParameters.append(columns.get(i)+"=s."+columns.get(i)+", ");
            }
        }
        sb.append(updateParameters.toString());
        sb.append("WHEN NOT MATCHED THEN ");
        StringBuilder insertColumns = new StringBuilder("( ");
        StringBuilder insertValues = new StringBuilder("( ");
        for ( int i = 0; i<columns.size(); i++ ) {
            if ( i == columns.size()-1 ) {
                insertColumns.append(columns.get(i)+" ) ");
                insertValues.append("s."+columns.get(i)+" ) ");
            } else {
                insertColumns.append(columns.get(i)+", ");
                insertValues.append("s."+columns.get(i)+", ");
            }
        }
        sb.append("INSERT "+insertColumns.toString());
        sb.append("VALUES "+insertValues.toString()+";");
        return sb.toString();
    }

    //=====================================================================
    //
    //  Start of query functions
    //
    //=====================================================================
    public boolean makeQuery( Query q ) {
        List<String> columns = listOfColumns(q.table);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String queryString = queryString(q, columns);
        System.out.println(queryString);
        try {
            stmt = con.prepareStatement(queryString);
            int index = 1;
            int counter = 0;
            for ( Value value : q.processedValues ) {
                if ( value.type == 0 || (value.type == 2 && value.variableData != null) ) {
                    /*String val = value.generateArray();
                    System.out.println("El value: "+val);
                    stmt.setObject(index, val);*/
                    /*if (isParsable(value.value)) {
                        stmt.setInt(index, Integer.parseInt(value.value));
                    } else {
                        stmt.setString(index, value.value);
                    }*/
                    index++;
                } else {
                    counter++;
                }
            }
            rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            List<String> result = new ArrayList<String>();
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                for ( int j = 1; j <= counter; j++) {
                    q.insertVariableData(j, rs.getString(j));
                    sb.append(rsmd.getColumnName(j)+": "+rs.getString(j)+", ");
                }
                result.add(sb.toString());
            }
            //System.out.println(result);
            q.sqlQuery = queryString;
            q.function = "query";
            q.setQueryResult(result);
            //System.out.println("Variables of q: "+q.variables);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public String queryString(Query q, List<String> columns) {
        StringBuilder sb = new StringBuilder("SELECT ");
        StringBuilder where = new StringBuilder();
        int j = 0;
        for ( int i = 0; i < q.values.length; i++ ) {
            String val = q.values[i];
            //System.out.println(q.processedValues[i]);
            //System.out.println("El tipo: "+q.processedValues[i].type);
            if ( (q.processedValues[i].type == 1) || (q.processedValues[i].type == 2 && q.processedValues[i].variableData == null) ) {
                sb.append(columns.get(i)+",");
            } else {
                if ( j == 0 ) {
                    //System.out.println("On enter query string: "+i+" : "+q.processedValues[i]);
                    where.append(" WHERE "+columns.get(i)+" IN ("+ q.processedValues[i].generateArray() +") ");
                } else {
                    //System.out.println("On enter query string: "+i+" : "+q.processedValues[i]);
                    where.append(" AND "+columns.get(i)+" IN ("+ q.processedValues[i].generateArray()+ ") ");
                }
                j++;
            }
        }
        sb = new StringBuilder(sb.reverse().toString().replaceFirst(",","")).reverse();
        sb.append(" FROM "+q.table+" "+where.toString());
        //System.out.println("El query_: "+sb.toString());
        return sb.toString();
    }

    //=====================================================================
    //
    //  Start of delete functions
    //
    //=====================================================================
    public boolean retractQuery( Query q ) {
        List<String> columns = listOfColumns(q.table);
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = retractQueryString(q, columns);
            stmt = con.prepareStatement(query);
            int index = 1;
            for ( String value : q.values ) {
                if (isParsable(value)) {
                    stmt.setInt(index, Integer.parseInt(value));
                } else {
                    stmt.setString(index, value);
                }
                index++;
            }
            int queryResult = stmt.executeUpdate();
            List<String> result = new ArrayList<String>();
            result.add("Deleted "+queryResult+" rows");
            q.sqlQuery = query;
            q.setQueryResult(result);
            return (queryResult > 0)? true : false;
        } catch(Exception e) {
            System.out.println(e);
            return true;
        }
    }

    public String retractQueryString( Query q, List<String> columns ) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(q.table);
        int j = 0;
        for ( int i = 0; i < q.values.length; i++ ) {
            String val = q.values[i];
            if ( val.equals("_") ) {
                //sb.append(columns.get(i)+",");
            } else {
                if ( j == 0 ) {
                    sb.append(" WHERE "+columns.get(i)+"=? ");
                } else {
                    sb.append(" AND "+columns.get(i)+"=? ");
                }
                j++;
            }
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }


    public List<String> listOfColumns( String table ) {
        List<String> results = new ArrayList<String>();
        StringBuilder q = new StringBuilder();
        q.append("SELECT COLUMN_NAME FROM "+databaseName+".INFORMATION_SCHEMA.COLUMNS");
        q.append(" WHERE TABLE_NAME = N'"+table+"'");
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(q.toString());
            while (rs.next()) {
                results.add(rs.getString(1));
            }
            return results;
        } catch(Exception e) {
            System.out.println(e);
            return new ArrayList<String>();
        }
    }

    public List<String> listOfPrimaryColumns(String table) {
        List<String> results = new ArrayList<String>();
        StringBuilder q = new StringBuilder();
        q.append("SELECT COLUMN_NAME FROM "+databaseName+".INFORMATION_SCHEMA.KEY_COLUMN_USAGE");
        q.append(" WHERE OBJECTPROPERTY(OBJECT_ID(CONSTRAINT_SCHEMA + '.' + QUOTENAME(CONSTRAINT_NAME)), 'IsPrimaryKey') = 1 ");
        q.append(" AND TABLE_NAME = '"+table+"'");
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(q.toString());
            while (rs.next()) {
                results.add(rs.getString(1));
            }
            return results;
        } catch(Exception e) {
            System.out.println(e);
            return new ArrayList<String>();
        }
    }

    public static boolean isParsable(String input) {
        boolean parsable = true;
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }

}
