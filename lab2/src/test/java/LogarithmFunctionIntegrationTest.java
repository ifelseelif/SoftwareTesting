import functions.logarithm.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class LogarithmFunctionIntegrationTest {

    private static Ln ln;
    private static Log2 log2;
    private static Log3 log3;
    private static Log5 log5;
    private static Log10 log10;
    private static LogarithmFunction logarithmFunction;
    private  final double DELTA = 0.01;

    @BeforeEach
     void setUp() {
        ln = Mockito.mock(Ln.class);
        log2 = Mockito.mock(Log2.class);
        log3 = Mockito.mock(Log3.class);
        log5 = Mockito.mock(Log5.class);
        log10 = Mockito.mock(Log10.class);

        when(ln.getAccuracy()).thenReturn(DELTA);

        logarithmFunction = new LogarithmFunction(ln, log2, log3, log5, log10);

        when(ln.calculate(-1)).thenThrow(new IllegalArgumentException());
    }

    @ParameterizedTest
    @MethodSource("provideDoubleValues")
    public void testLogarithmFunction(double expected, double value) {
        when(ln.calculate(value)).thenReturn(Math.log(value));
        when(log2.calculate(value)).thenReturn(Math.log(value) / Math.log(2));
        when(log2.calculate(Math.pow(value,2))).thenReturn(Math.log(Math.pow(value,2)) / Math.log(2));
        when(log3.calculate(value)).thenReturn(Math.log(value) / Math.log(3));
        when(log5.calculate(value)).thenReturn(Math.log(value) / Math.log(5));
        when(log10.calculate(value)).thenReturn(Math.log(value) / Math.log(10));

        Assertions.assertEquals(expected, logarithmFunction.calculate(value), DELTA);
    }

    private static Stream<Arguments> provideDoubleValues() {
        return Stream.of(
                Arguments.of(-3.66, 10),
                Arguments.of(-4.4832693, 0.6),
                Arguments.of(-4.605, 0.4)
        );
    }

    @Test
    public void testNegativeLogarithmFunction() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> logarithmFunction.calculate(-1));
    }

}
