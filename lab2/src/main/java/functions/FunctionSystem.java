package functions;

import functions.logarithm.LogarithmFunction;
import functions.trigonometric.TrigonometricFunction;

public class FunctionSystem extends Function {

    private final TrigonometricFunction trigonometricFunction;
    private final LogarithmFunction logarithmFunction;

    public FunctionSystem(TrigonometricFunction trigonometricFunction, LogarithmFunction logarithmFunction) {
        super(trigonometricFunction.getAccuracy());
        this.trigonometricFunction = trigonometricFunction;
        this.logarithmFunction = logarithmFunction;
    }

    @Override
    public double calculate(double x) {
        return x <= 0 ? trigonometricFunction.calculate(x) : logarithmFunction.calculate(x);
    }
}
