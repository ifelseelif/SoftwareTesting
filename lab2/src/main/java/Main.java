import functions.FunctionSystem;
import functions.logarithm.*;
import functions.trigonometric.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CSV csv = new CSV();

        Sine sine = new Sine(0.000001);
        Cosine cosine = new Cosine(sine);
        Tangent tangent = new Tangent(sine, cosine);
        Cotangent cotangent = new Cotangent(sine, cosine);
        Secant secant = new Secant(cosine);
        Cosecant cosecant = new Cosecant(sine);
        TrigonometricFunction trigonometricFunction = new TrigonometricFunction(sine, cosine, tangent, cotangent, secant, cosecant);

        Ln ln = new Ln(0.000001);
        Log2 log2 = new Log2(ln);
        Log3 log3 = new Log3(ln);
        Log5 log5 = new Log5(ln);
        Log10 log10 = new Log10(ln);
        LogarithmFunction logarithmFunction = new LogarithmFunction(ln, log2, log3, log5, log10);

        FunctionSystem functionSystem = new FunctionSystem(trigonometricFunction, logarithmFunction);


        csv.writeFuncToCsv(log2, 0, 11, 0.1);
        csv.writeFuncToCsv(log3, 0, 11, 0.1);
        csv.writeFuncToCsv(log5, 0, 11, 0.1);
        csv.writeFuncToCsv(log10, 0, 11, 0.1);


        csv.writeFuncToCsv(sine, -Math.PI, Math.PI, 0.1);
        csv.writeFuncToCsv(ln, 0, 11, 0.1);
        csv.writeFuncToCsv(trigonometricFunction, -1.57, -1.2, 0.01);
        csv.writeFuncToCsv(logarithmFunction, 0, 11, 0.1);

        csv.writeFuncToCsv(functionSystem, -10, 10, 0.1);
    }
}
