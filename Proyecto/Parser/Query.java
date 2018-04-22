public class Query {

    String table;
    String[] values;

    public Query( String query ) {
        String[] data = query.split("\\(");
        this.table = data[0];
        this.values = data[1].replace(").", "").replace("):-", "").replace("),", "").split(",");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: "+this.table);
        sb.append("\nValues: ");
        for ( String s : this.values ) {
            sb.append(s+", ");
        }
        return sb.toString();
    }

}
