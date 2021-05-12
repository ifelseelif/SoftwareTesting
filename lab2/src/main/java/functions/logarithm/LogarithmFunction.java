package functions.logarithm;

import functions.Function;

public class LogarithmFunction extends Function {

    private final Ln ln;
    private final Log2 log2;
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    public LogarithmFunction(Ln ln, Log2 log2, Log3 log3, Log5 log5, Log10 log10) {
        super (ln.getAccuracy ());
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public double calculate(double x) {
        if (x == 1) {
            throw new IllegalArgumentException ("");
        }

        return
                ((((log5.calculate (x) - log5.calculate (x)) - log2.calculate (x)) * log3.calculate (x)) /
                        ((log3.calculate (x) + log10.calculate (x)) - log3.calculate (x))) - (
                        (pow (log2.calculate (x) / ln.calculate (x), 3)) - (log2.calculate (pow (x, 2)) + log10.calculate (x))
                );
    }

    private double pow(double x, int degree) {
        double result = x;
        for (int i = 0; i < degree - 1; i++) {
            result *= result;
        }

        return result;
    }
}
