import java.text.DecimalFormat;

public class Complex implements Cloneable{
    /* imaginary number = (a + b * i) */
    private double a; //real part
    private double b; //imaginary part

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex(double a) {
        this(a, 0);
    }

    public Complex() {
        this(0, 0);
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    /* a + bi + c + di = (a + c) + (b + d)i */
    public Complex add(Complex other) {
        double newestA = this.a + other.getRealPart();
        double newestB = this.b + other.getImaginaryPart();

        //format number
        newestA = formatDecimal(newestA);
        newestB = formatDecimal(newestB);

        return new Complex(newestA, newestB);
    }

    /* a + bi - (c + di) = (a - c) + (b - d)i */
    public Complex subtract(Complex other) {
        double newestA = this.a - other.getRealPart();
        double newestB = this.b - other.getImaginaryPart();

        //format number
        newestA = formatDecimal(newestA);
        newestB = formatDecimal(newestB);

        return new Complex(newestA, newestB);
    }

    /* (a + bi)*(c + di) = (ac - bd) + (bc + ad)i */
    public Complex multiply(Complex other) {
        double newestA = this.a * other.getRealPart() - this.b * other.getImaginaryPart();
        double newestB = this.b * other.getRealPart() + this.a * other.getImaginaryPart();

        //format number
        newestA = formatDecimal(newestA);
        newestB = formatDecimal(newestB);

        return new Complex(newestA, newestB);
    }

    /* (a + bi)/(c + di) = (ac + bd)/(c^2 + d^2 ) + (bc - ad)i/(c^2 + d^2 ) */
    public Complex divide(Complex other) {
        double newestA = (this.a * other.getRealPart() + this.b * other.getImaginaryPart()) /
                (Math.pow(other.getRealPart(), 2) + Math.pow(other.getImaginaryPart(), 2));

        double newestB = (this.b * other.getRealPart() - this.a * other.getImaginaryPart()) /
                (Math.pow(other.getRealPart(), 2) + Math.pow(other.getImaginaryPart(), 2));

        //format number
        newestA = formatDecimal(newestA);
        newestB = formatDecimal(newestB);

        return new Complex(newestA, newestB);
    }

    private double formatDecimal(double number) {
        /*return formatted double that only include 4 digit after decimal point*/
        return Double.valueOf(new DecimalFormat(".####").format(number));
    }

    /* |a + bi| = sqrt(a^2 + b^2)  */
    public double abs() {
        /* return absolute value of instance complex number */
        double result = Math.sqrt(Math.pow(this.getRealPart(), 2) + Math.pow(this.getImaginaryPart(), 2));
        //format number
        result = formatDecimal(result);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "("+ a + " + " + b + "i)";
    }
}
