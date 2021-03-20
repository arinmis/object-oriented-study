import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *  Programming Exercise 13.15
 *
 *  (Use BigInteger for the Rational class) Redesign and implement the
 *  Rational class in Listing 13.13 using BigInteger for the numerator and
 *  denominator.
 *
 *  @author Mustafa Arinmis
 *  @since 26.12.2020
 * */

class Rational  extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger[] r = new BigInteger[2];

    /** Default constructor */
    public Rational() {
        this(new BigInteger("0"), new BigInteger("1"));
    }

    @Override
    public double doubleValue() {
        BigDecimal numerator = new BigDecimal(r[0]);
        BigDecimal denominator = new BigDecimal(r[1]);
        return numerator.divide(denominator).doubleValue();
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        r[0] = ((denominator.compareTo(new BigInteger("0")) < 0) ?
                new BigInteger("1") : new BigInteger("1"))
                .multiply(numerator).divide(gcd);
        r[1] = abs(denominator).divide(gcd);
    }

    /** Find GCD of two numbers */
    private BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger t1 = abs(n);
        BigInteger t2 =abs(d);
        BigInteger remainder = t1.mod(t2);

        while (!remainder.equals(new BigInteger("0"))) {
            t1 = t2;
            t2 = remainder;
            remainder = t1.mod(t2);
        }

        return t2;
    }

    /* return absolute value's of given BigInteger */
    private BigInteger abs(BigInteger bigInteger) {
        if(bigInteger.compareTo(new BigInteger("0")) < 0)
            return bigInteger.multiply(new BigInteger("-1"));
        else
            return bigInteger;
    }

    /*Return numerator*/
    public BigInteger getNumerator() {
        return r[0];
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return r[1];
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator())
                .add(r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator())
                .subtract(r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Multiply a rational number to this rational */
    public Rational multiply(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getNumerator());
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    /** Divide a rational number from this rational */
    public Rational divide(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator());
        BigInteger d = r[1].multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (r[1].compareTo(new BigInteger("1")) == 0)
            return r[0] + "";
        else
            return r[0] + "/" + r[1];
    }

  /** Override the equals method in the Object class */
    public boolean equals(Object parm1) {
        // rationals are equal if compareTo method return 0
        return (this.subtract((Rational) (parm1))).getNumerator()
                .compareTo(new BigInteger("0")) == 0;
    }

    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override
    public long longValue() {
        return (long)doubleValue();
    }

    @Override
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override
    public int compareTo(Rational o) {
        BigInteger zero = new BigInteger("0");
        return (this.subtract(o)).getNumerator().compareTo(zero);
    }
}