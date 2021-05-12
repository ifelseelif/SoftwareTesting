package functions.trigonometric;

import functions.Function;

public class Cosine extends Function {

    private final Sine sine;

    public Cosine(Sine sine) {
        super(sine.getAccuracy());
        this.sine = sine;
    }

    @Override
    public double calculate(double x) {

        while (x > 2 * Math.PI) {
            x -= 2 * Math.PI;
        }

        while (x < 0) {
            x += 2 * Math.PI;
        }

        if (x > Math.PI/2 && x < 3*Math.PI/2) {
            return -Math.sqrt(1 - Math.pow(sine.calculate(x),2));
        } else {
            return Math.sqrt(1 - Math.pow(sine.calculate(x),2));
        }
    }
}
