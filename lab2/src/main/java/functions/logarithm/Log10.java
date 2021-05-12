package functions.logarithm;

import functions.Function;

public class Log10 extends Function {

    private final Ln ln;

    public Log10(Ln ln) {
        super(ln.getAccuracy());
        this.ln = ln;
    }

    @Override
    public double calculate(double x) {
        return ln.calculate(x) / ln.calculate(10);
    }
}
