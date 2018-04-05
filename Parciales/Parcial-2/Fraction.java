public class Fraction {

    int a;
    int b;

    public Fraction( int a, int b ) {
        this.a = a;
        this.b = b;
    }

    public Fraction operation( char op, Fraction o ) {
        switch (op) {
            case '+':
                return sum(o);
            case '-':
                return sub(o);
            case '*':
                return mul(o);
            case '/':
                return div(o);
        }
        return new Fraction(-1, -1);
    }

    public Fraction sum(Fraction o) {
        int den = o.b * this.b;
        int num = (this.a*o.b) + (o.a*this.b);
        return new Fraction(num, den);
    }

    public Fraction sub(Fraction o) {
        int den = o.b * this.b;
        int num = (this.a*o.b) - (o.a*this.b);
        return new Fraction(num, den);
    }

    public Fraction div(Fraction o) {
        int num = this.a * o.b;
        int den = o.a * this.b;
        return new Fraction(num, den);
    }

    public Fraction mul(Fraction o) {
        int num = this.a * o.a;
        int den = o.b * this.b;
        return new Fraction(num, den);
    }

    @Override
    public String toString() {
        return this.a + "/" + this.b;
    }

}
