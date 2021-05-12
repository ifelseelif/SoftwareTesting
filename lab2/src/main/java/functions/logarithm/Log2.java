package functions.logarithm;

import functions.Function;

public class Log2 extends Function {

    public final Ln ln;

    public Log2(Ln ln) {
        super(ln.getAccuracy());
        this.ln = ln;
    }

    @Override
    public double calculate(double x) {
        return ln.calculate(x) / ln.calculate(2);
    }
}
