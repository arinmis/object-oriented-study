/**
 *  Programming Exercise 13.14
 *
 *  (Demonstrate the benefits of encapsulation) Rewrite the Rational class in
 *  Listing 13.13 using a new internal representation for the numerator and denomina-
 *  tor. Create an array of two integers as follows:
 *
 *  private long[] r = new long[2];
 *
 *  Use r[0] to represent the numerator and r[1] to represent the denominator.
 *  The signatures of the methods in the Rational class are not changed, so a client
 *  application that uses the previous Rational class can continue to use this new
 *  Rational class without being recompiled.
 *
 *  @author Mustafa Arinmis
 *  @since 26.12.2020
 * */

class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private long[] r = new long[2];

    /** Default constructor */
    public Rational() {
        this(0, 1);
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        r[0] = ((denominator > 0) ? 1 : -1) * numerator / gcd;
        r[1] = Math.abs(denominator) / gcd;
    }

    /** Find GCD of two numbers */
    private long gcd(long n, long d) {
        long t1 = Math.abs(n);
        long t2 = Math.abs(d);
        long remainder = t1 % t2;

        while (remainder != 0) {
            t1 = t2;
            t2 = remainder;
            remainder = t1%t2;
        }

        return t2;
    }

    /** Return numerator */
    public long getNumerator() {
        return r[0];
    }

    /** Return denominator */
    public long getDenominator() {
        return r[1];
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        long n = r[0] * secondRational.getDenominator() +
                r[1] * secondRational.getNumerator();
        long d = r[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        long n = r[0] * secondRational.getDenominator()
                - r[1] * secondRational.getNumerator();
        long d = r[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /** Multiply a rational number to this rational */
    public Rational multiply(Rational secondRational) {
        long n = r[0] * secondRational.getNumerator();
        long d = r[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /** Divide a rational number from this rational */
    public Rational divide(Rational secondRational) {
        long n = r[0] * secondRational.getDenominator();
        long d = r[1] * secondRational.r[0];
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (r[1] == 1)
            return r[0] + "";
        else
            return r[0] + "/" + r[1];
    }

    /** Override the equals method in the Object class */
    public boolean equals(Object parm1) {
        return (this.subtract((Rational) (parm1))).getNumerator() == 0;
    }

    /** Override the hashCode method in the Object class */
    public int hashCode() {
        return new Double(this.doubleValue()).hashCode();
    }

    /** Override the abstract intValue method in java.lang.Number */
    public int intValue() {
        return (int)doubleValue();
    }

    /** Override the abstract floatValue method in java.lang.Number */
    public float floatValue() {
        return (float)doubleValue();
    }

    /** Override the doubleValue method in java.lang.Number */
    public double doubleValue() {
        return r[1] * 1.0 / r[1];
    }

    /** Override the abstract longValue method in java.lang.Number */
    public long longValue() {
        return (long)doubleValue();
    }

    @Override
    public int compareTo(Rational o) {
        if ((this.subtract(o)).getNumerator() > 0)
            return 1;
        else if ((this.subtract(o)).getNumerator() < 0)
            return -1;
        else
            return 0;
    }
}