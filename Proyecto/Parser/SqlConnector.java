import java.sql.*;

public class SqlConnector {

    // Create a variable for the connection string.
    String connectionUrl;
    // Declare the JDBC objects.
    Connection con = null;

    public SqlConnector() {
        try {
            this.connectionUrl = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=escuela;integratedSecurity=false;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl,"sa","compiladores@Bda10");
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void insertTuple( Query q ) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String query = insertQueryString(q);
            stmt.executeUpdate(query);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private String insertQueryString( Query q ) {
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
