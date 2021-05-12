package functions.logarithm;

import functions.Function;

public class Log3 extends Function {

    private final Ln ln;

    public Log3(Ln ln) {
        super(ln.getAccuracy());
        this.ln = ln;
    }

    @Override
    public double calculate(double x) {
        return ln.calculate(x) / ln.calculate(3);
    }
}
