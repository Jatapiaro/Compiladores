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
                if ( !q.hasUnderscoreParams ) {
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
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String query = insertQueryString(q);
            int affectedRows = stmt.executeUpdate(query);
            q.sqlQuery = query;
            q.function = "insert";
            List<String> result = new ArrayList<String>();
            result.add("Created: "+affectedRows+" rows");
            q.setQueryResult(result);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String insertQueryString( Query q ) {
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(q.table);
        query.append(" VALUES(");
        for ( String s : q.values ) {
            if (isParsable(s)) {
                query.append(Integer.parseInt(s)+",");
            } else {
                query.append("'"+s+"',");
            }
        }
        query.append(")");
        String s = query.reverse().toString().replaceFirst(",", "");
        s = new StringBuilder(s).reverse().toString();
        return s;
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
            for ( String value : q.values ) {
                if ( !value.equals("_") ) {
                    if (isParsable(value)) {
                        stmt.setInt(index, Integer.parseInt(value));
                    } else {
                        stmt.setString(index, value);
                    }
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
                    sb.append(rsmd.getColumnName(j)+": "+rs.getString(j)+", ");
                }
                result.add(sb.toString());
            }
            //System.out.println(result);
            q.sqlQuery = queryString;
            q.function = "query";
            q.setQueryResult(result);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return true;
        }
    }

    public String queryString(Query q, List<String> columns) {
        StringBuilder sb = new StringBuilder("SELECT ");
        StringBuilder where = new StringBuilder();
        int j = 0;
        for ( int i = 0; i < q.values.length; i++ ) {
            String val = q.values[i];
            if ( val.equals("_") ) {
                sb.append(columns.get(i)+",");
            } else {
                if ( j == 0 ) {
                    where.append(" WHERE "+columns.get(i)+"=? ");
                } else {
                    where.append(" AND "+columns.get(i)+"=? ");
                }
                j++;
            }
        }
        sb = new StringBuilder(sb.reverse().toString().replaceFirst(",","")).reverse();
        sb.append(" FROM "+q.table+" "+where.toString());
        //System.out.println(sb.toString());
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
            stmt = con.prepareStatement(retractQueryString(q, columns));
            int index = 1;
            for ( String value : q.values ) {
                if (isParsable(value)) {
                    stmt.setInt(index, Integer.parseInt(value));
                } else {
                    stmt.setString(index, value);
                }
                index++;
            }
            return (stmt.executeUpdate() > 0)? true : false;
        } catch(Exception e) {
            System.out.println(e);
            return true;
        }
    }

    public String retractQueryString( Query q, List<String> columns ) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(q.table);
        int index = 0;
        for ( String values : q.values ) {
            if (index == 0) {
                String col = columns.get(0);
                sb.append(" WHERE "+col+"=? ");
                columns.remove(0);
            } else {
                String col = columns.get(0);
                sb.append("AND "+col+"=? ");
                columns.remove(0);
            }
            index++;
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
