package functions.trigonometric;

import functions.Function;

public class Secant extends Function {

    private final Cosine cosine;

    public Secant(Cosine cosine) {
        super(cosine.getAccuracy());
        this.cosine = cosine;
    }

    @Override
    public double calculate(double x)
    {
        if (x == Math.PI / 2) {
            return Double.POSITIVE_INFINITY;
        }

        return 1 / cosine.calculate(x);
    }
}
