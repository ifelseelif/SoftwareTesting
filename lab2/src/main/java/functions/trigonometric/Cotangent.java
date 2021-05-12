package functions.trigonometric;

import functions.Function;

public class Cotangent extends Function {

    private final Sine sine;
    private final Cosine cosine;

    public Cotangent(Sine sine, Cosine cosine) {
        super(sine.getAccuracy());
        this.sine = sine;
        this.cosine = cosine;
    }

    @Override
    public double calculate(double x) {
        return cosine.calculate(x) / sine.calculate(x);
    }
}
