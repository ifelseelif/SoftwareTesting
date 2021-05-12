package functions.logarithm;

import functions.Function;

public class Ln extends Function {

    public Ln(double accuracy) {
        super(accuracy);
    }

    @Override
    public double calculate(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Theta must be > 0 to calculate logarithm");
        }
        if (getAccuracy() < 0) {
            throw new IllegalArgumentException("The accuracy below zero");
        }
        double result = 0;
        double multiplier = (x - 1) / (x + 1);
        double step = multiplier * 2;
        int i;

        for (i = 1; Math.abs(step) > getAccuracy() && i != Integer.MAX_VALUE - 2; i += 2) {
            step = 2 / (float) (i) * Math.pow(multiplier, i);
            result += step;
            if (!Double.isFinite(result) || !Double.isFinite(multiplier)) {
                throw new IllegalArgumentException("Can't reach the accuracy");
            }
        }
        if (i == Integer.MAX_VALUE || !Double.isFinite(result)) {
            throw new IllegalArgumentException("Can't reach the accuracy");
        }
        return result;
    }

    @Override
    public double getAccuracy() {
        return super.getAccuracy();
    }
}
