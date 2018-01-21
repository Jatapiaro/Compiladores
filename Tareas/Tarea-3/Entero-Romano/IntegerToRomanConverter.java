public class IntegerToRomanConverter {

    StringBuilder thousand, hundred, ten, unit;

    String[] unitSimbols = { "IX", "V", "IV", "I" };
    int[] unitValues = { 9, 5, 4, 1 };

    String[] tenSimbols = { "XC", "L", "XL", "X" };
    int[] tenValues = { 90, 50, 40, 10 };

    String[] hundredSimbols = { "CM", "D", "CD", "C" };
    int[] hundredValues = { 900, 500, 400, 100 };

    public IntegerToRomanConverter() {
        this.thousand = new StringBuilder();
        this.hundred = new StringBuilder();
        this.ten = new StringBuilder();
        this.unit = new StringBuilder();
    }

    public void addUnit( String unit ) {
        int value = Integer.parseInt(unit);
        if ( value > 0 ) {
            int pos = 0;
            while( pos < this.unitSimbols.length && value > 0 ) {
                if ( value - this.unitValues[pos] < 0 ) {
                    pos++;
                } else {
                    this.unit.append(this.unitSimbols[pos]);
                    value -= this.unitValues[pos];
                }
            }
        }
    }

    public void addTen( String ten ) {
        int value = Integer.parseInt(ten);
        value *= 10;
        if ( value > 0 ) {
            int pos = 0;
            while( pos < this.tenSimbols.length && value > 0 ) {
                if ( value - this.tenValues[pos] < 0 ) {
                    pos++;
                } else {
                    this.ten.append(this.tenSimbols[pos]);
                    value -= this.tenValues[pos];
                }
            }
        }
    }

    public void addHundred( String hundred ) {
        int value = Integer.parseInt(hundred);
        value *= 100;
        if ( value > 0 ) {
            int pos = 0;
            while( pos < this.hundredSimbols.length && value > 0 ) {
                if ( value - this.hundredValues[pos] < 0 ) {
                    pos++;
                } else {
                    this.hundred.append(this.hundredSimbols[pos]);
                    value -= this.hundredValues[pos];
                }
            }
        }
    }

    public void addThousand( String thousand ) {
        int value = Integer.parseInt(thousand);
        if ( value > 0) {
            for ( int i = 0; i < value; i++ ) {
                this.thousand.append("M");
            }
        }
    }


    @Override
    public String toString() {
        return this.thousand.toString() + "" + this.hundred.toString() + "" + this.ten.toString() + "" + this.unit.toString();
    }

}
