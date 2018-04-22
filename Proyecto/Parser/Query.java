public class Query {

    String table, function;
    String[] values;

    public Query( String query, String function ) {

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
