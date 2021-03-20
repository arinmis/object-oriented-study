public class ComplexMatrix extends GenericMatrix<Complex>{
    @Override
    protected Complex add(Complex c1, Complex c2) {
        return c1.add(c2);
    }

    @Override
    protected Complex multiply(Complex c1, Complex c2) {
        return c1.multiply(c2);
    }

    @Override
    protected Complex zero() {
        return new Complex(0, 0);
    }
}
