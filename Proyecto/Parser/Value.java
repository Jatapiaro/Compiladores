import java.util.*;
public class Value {

    int column;
    String value;
    // 0 simple, 1 underscore, 2 variable
    int type;
    List<String> variableData;
    public Value(int column, String value, int type) {
        this.column = column;
        this.value = value;
        this.type = type;
    }

    public void setVariableData( List<String> variableData ) {
        this.variableData = variableData;
    }

    public String generateArray() {
        if ( type == 0 ) {
            return "'"+this.value+"'";
        } else if ( type == 2 ) {
            StringBuilder sb = new StringBuilder();
            for ( int i = 0; i<this.variableData.size(); i++ ) {
                if (i == this.variableData.size()-1) {
                    sb.append("'"+this.variableData.get(i).trim()+"'");
                } else {
                    sb.append("'"+this.variableData.get(i).trim()+"',");
                }
            }
            return sb.toString();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append("column : " + this.column + ", ");
        sb.append("value : " + this.value + ", ");
        sb.append("type : " + this.type + "]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        Value other = (Value)o;
        return other.value.equals(this.value);
    }

}
