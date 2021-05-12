package functions;

public abstract class Function {
    private double accuracy;

    public Function(double accuracy) {
        this.accuracy = accuracy;
    }

    public abstract double calculate(double x);

    public double getAccuracy() {
        return accuracy;
    }
}
