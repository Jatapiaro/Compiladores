import java.util.*;

public class Query {

    String table, function, sqlQuery;
    String[] values;
    boolean hasUnderscoreParams, hasVariables;
    List<String> queryResult;
    Value[] processedValues;
    HashMap<String, List<String>> variables;

    public Query( String query, String function ) {
        this.hasUnderscoreParams = false;
        this.hasVariables = false;
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
        /*System.out.print("Proccesed Values: ");
        for ( Value v : this.processedValues ) {
            System.out.print(v+"\n");
        }
        System.out.println("");*/
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
        this.processedValues = new Value[this.values.length];
        int i = 0;
        for ( String value : this.values ) {
            if ( value.equals("_") ) {
                this.hasUnderscoreParams = true;
                this.processedValues[i] = new Value(i+1, "_", 1);
                i++;
                continue;
            } else if ( value.startsWith("_") ) {
                String aux = value.replace("_", "");
                if ( this.isStringUpperCase(aux) ) {
                    this.hasVariables = true;
                    this.processedValues[i] = new Value(i+1, value, 2);
                    i++;
                }
            } else {
                this.processedValues[i] = new Value(i+1, value, 0);
                i++;
            }
        }
    }

    public void setQueryResult( List<String> result ) {
        this.queryResult = result;
    }

    public String printQueryResult() {
        StringBuilder sb = new StringBuilder("\nResult of "+this.function+"( "+this.sqlQuery+" ) in "+this.table+":\n");
        int row = 1;
        for ( String s : this.queryResult ) {
            sb.append(row+". "+s+"\n");
            row++;
        }
        sb.append("\nx-x-x-x-x-x-x-x\n");
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

    private static boolean isStringUpperCase(String str){
        //convert String to char array
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++){

            //if any character is not in upper case, return false
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }

        return true;
    }

    public void setVariablesData( HashMap<String, List<String>> variables ) {
        this.variables = variables;
    }

    public void insertVariableData(int column, String data) {
        for ( Value v : this.processedValues ) {
            if ( v.type == 2 && v.column == column ) {
                this.appendResultToVariable(v.value, data);
                break;
            }
        }
    }

    private void appendResultToVariable(String variable, String result) {
        if ( !this.variables.containsKey(variable) ) {
            List<String> l = new ArrayList<String>();
            this.variables.put(variable, l);
        }
        if ( !this.variables.get(variable).contains(result) ) {
            this.variables.get(variable).add(result);
        }
    }

    public boolean isQuery() {
        return this.hasUnderscoreParams || this.hasVariables;
    }

    public void processVariables() {
        for ( Value v : this.processedValues ) {
            if ( v.type == 2 && this.variables.containsKey(v.value) ) {
                //System.out.println("Si tiene la llave n: "+this.variables.get(v.value));
                v.setVariableData(this.variables.get(v.value));
                //System.out.println(v.variableData);
            }
        }
    }

}
