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
                return insertTuple(q);
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
            stmt.executeUpdate(query);
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
