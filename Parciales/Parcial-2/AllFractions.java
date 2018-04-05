public class AllFractions {

    StringBuilder sb;

    public AllFractions() {
        sb = new StringBuilder();
    }

    public void addFraction(Fraction f) {
        double val = (double)f.a / (double)f.b;
        sb.append(val);
    }

    public void addOperand(char operand) {
        sb.append(operand);
    }

    @Override
    public String toString() {
        return this.sb.toString();
    }

}
