package functions.trigonometric;

import functions.Function;

public class Tangent extends Function {

    Sine sine;
    Cosine cosine;

    public Tangent(Sine sine, Cosine cosine) {
        super(sine.getAccuracy());
        this.sine = sine;
        this.cosine = cosine;
    }

    @Override
    public double calculate(double x) {
        return sine.calculate(x) / cosine.calculate(x);
    }
}
