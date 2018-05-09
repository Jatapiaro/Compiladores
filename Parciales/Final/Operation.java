import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Operation {
    String operation;
    double result;
    public Operation(String operation){

        List<Double> values = new ArrayList<Double>();

        this.operation = operation;
        String[] vals = this.operation.split("\\+|\\-|\\*|\\/");

        String operations = this.operation.replaceAll("[a-zA-Z0-9]", "");
        operations = operations.replaceAll("%", "");

        for ( String v : vals ) {
            String[] numbers = v.split("%");
            values.add(Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]));
        }
        char[] opers = operations.toCharArray();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for ( Double d : values ) {
            sb.append(d);
            if ( i<opers.length ) {
                sb.append(opers[i]);
                i++;
            }
        }
        this.operation = sb.toString();
    }
}
