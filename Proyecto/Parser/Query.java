import java.util.*;

public class Query {

    String table, function, sqlQuery;
    String[] values;
    boolean hasUnderscoreParams;
    List<String> queryResult;

    public Query( String query, String function ) {
        this.hasUnderscoreParams = false;
        this.queryResult = new ArrayList<String>();
        this.sqlQuery = "";
        switch (function) {
            case "simple":
                simpleQuery(query);
                break;
            case "retract":
                retractQuery(query);
                break;
        }

    }

    private void simpleQuery(String query) {
        createQueryData(query);
        this.function = "simple";
    }

    private void retractQuery(String query) {
        StringBuilder sb = new StringBuilder();
        query = query.replace("retract(", "");
        query = sb.append(query).reverse().toString();
        query = query.replaceFirst("\\)", "");
        sb = new StringBuilder(query).reverse();
        createQueryData(sb.toString());
        this.function = "retract";
    }

    private void createQueryData(String query) {
        String[] data = query.split("\\(");
        this.table = data[0];
        this.values = data[1].replace(")", "").split(",");
        for ( String value : this.values ) {
            if (value.equals("_")) {
                this.hasUnderscoreParams = true;
            }
        }
    }

    public void setQueryResult( List<String> result ) {
        this.queryResult = result;
    }

    public String printQueryResult() {
        StringBuilder sb = new StringBuilder("Result of "+this.function+"( "+this.sqlQuery+" ) in "+this.table+":\n");
        int row = 1;
        for ( String s : this.queryResult ) {
            sb.append(row+". "+s+"\n");
            row++;
        }
        sb.append("------------------");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: "+this.table);
        sb.append("\nValues: ");
        for ( String s : this.values ) {
            sb.append(s+", ");
        }
        sb.append("\nAs: "+this.function);
        sb.append("\n---------");
        return sb.toString();
    }

}
