import java.util.*;

public class Rule {

    public Stack<Query> queries;
    public HashMap<String, List<String>> variables;

    public Rule() {
        this.queries = new Stack<Query>();
        this.variables = new HashMap<String, List<String>>();
    }

    public void addQueryToStack( Query q ) {
        q.setVariablesData(this.variables);
        this.queries.push(q);
    }

    public void appendResultToVariable(String variable, String result) {
        if ( !this.variables.containsKey(variable) ) {
            List<String> l = new ArrayList<String>();
            this.variables.put(variable, l);
        }
        this.variables.get(variable).add(result);
    }

    public List<String> getVariableData(String variable) {
        return this.variables.get(variable);
    }


}
