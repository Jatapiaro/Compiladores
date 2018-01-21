import java.util.*;
public class InfixToPosfixConverter {

    StringBuilder sb;
    List<Character> list;
    Stack<Character> st;

    public InfixToPosfixConverter() {
        restart();
    }

    public void addToken( String token ) {
        sb.append(token);
    }

    public String[] makeConversion() {
        char[] tokens = sb.toString().toCharArray();
        for(char t : tokens) {
            if ( Character.isDigit(t) ) {
                list.add(t);
            } else {
                this.pushOperatorToStack(t);
            }
        }
        while ( !this.st.empty() ) {
            this.list.add(this.st.pop());
        }
        StringBuilder s = new StringBuilder();
        for(char t : this.list) {
            s.append(""+t);
        }

        String[] result = new String[2];
        result[0] = sb.toString();
        result[1] = s.toString();
        return result;
    }

    private void pushOperatorToStack( char operator ) {

        int operatorHerarchy = this.getHerarchyValue(operator);
        if ( this.st.empty() ) {
            st.push(operator);
        } else {

            while( !this.st.empty() && isTopGreatherThanEntry(operatorHerarchy)) {
                this.list.add(this.st.pop());
            }
            st.push(operator);

        }

    }

    private boolean isTopGreatherThanEntry(int operatorHerarchy) {

        char peek = this.st.peek();
        int peekValue = this.getHerarchyValue(peek);
        return (peekValue >= operatorHerarchy)? true : false;

    }

    private int getHerarchyValue( char operator ) {
        if ( operator == '+' || operator == '-' ) {
            return 0;
        } else {
            return 1;
        }
    }

    private void restart() {
        sb = new StringBuilder();
        list = new ArrayList<Character>();
        st = new Stack<Character>();
    }



}
