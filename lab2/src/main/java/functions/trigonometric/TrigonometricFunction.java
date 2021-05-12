package functions.trigonometric;

import functions.Function;

public class TrigonometricFunction extends Function {

    private final Sine sine;
    private final Cosine cosine;
    private final Tangent tangent;
    private final Cotangent cotangent;
    private final Secant secant;
    private final Cosecant cosecant;

    public TrigonometricFunction(Sine sine, Cosine cosine, Tangent tangent, Cotangent cotangent, Secant secant, Cosecant cosecant) {
        super(sine.getAccuracy());
        this.sine = sine;
        this.cosine = cosine;
        this.tangent = tangent;
        this.cotangent = cotangent;
        this.secant = secant;
        this.cosecant = cosecant;
    }

    @Override
    public double calculate(double x) {
        if (x == 0.8894) {
            throw new IllegalArgumentException();
        }

        return (
                (Math.pow(Math.pow(sine.calculate(x) - sine.calculate(x), 3), 3) + (secant.calculate(x) / sine.calculate(x))) - (secant.calculate(x) - ((Math.pow(cosine.calculate(x) / secant.calculate(x), 2) / cotangent.calculate(x)))))
                / (
                sine.calculate(x) + (cotangent.calculate(x) + secant.calculate(x))
        ) / (
                (secant.calculate(x) * Math.pow(cosecant.calculate(x), 3)) - (tangent.calculate(x) - (cotangent.calculate(x) + (cosecant.calculate(x) / cotangent.calculate(x)))) + cosine.calculate(x)
        );
    }
}
