package functions.trigonometric;

import functions.Function;

public class Cosecant extends Function {

    private final Sine sine;

    public Cosecant(Sine sine) {
        super(sine.getAccuracy());
        this.sine = sine;
    }

    @Override
    public double calculate(double x) {
        if (x == 0) {
            return Double.POSITIVE_INFINITY;
        }

        return 1 / sine.calculate(x);
    }
}
