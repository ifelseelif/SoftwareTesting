import functions.logarithm.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class BasicLogFunctionIntegrationTest {
    private static Ln ln;
    private final double DELTA = 0.0001;

    @BeforeAll
    static void setUp() {
        ln = Mockito.mock(Ln.class);

        when(ln.calculate(0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(ln.calculate(1)).thenReturn(0d);
        when(ln.calculate(10)).thenReturn(2.3025850);
        when(ln.calculate(0.5)).thenReturn(-0.693147);
    }

    @ParameterizedTest
    @MethodSource("provideLog2Values")
    public void testLog2Integration(double expected, double value) {
        Log2 log2 = new Log2(ln);
        when(ln.calculate(2)).thenReturn(0.69314718056);
        Assertions.assertEquals(expected, log2.calculate(value), DELTA);
    }

    private static Stream<Arguments> provideLog2Values() {
        return Stream.of(
                Arguments.of(Double.NEGATIVE_INFINITY, 0),
                Arguments.of(0, 1),
                Arguments.of(3.32192809489, 10),
                Arguments.of(-1, 0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLog3Values")
    public void testLog3Integration(double expected, double value) {
        Log3 log3 = new Log3(ln);
        when(ln.calculate(3)).thenReturn(1.098612288);
        Assertions.assertEquals(expected, log3.calculate(value), DELTA);
    }

    private static Stream<Arguments> provideLog3Values() {
        return Stream.of(
                Arguments.of(Double.NEGATIVE_INFINITY, 0),
                Arguments.of(0, 1),
                Arguments.of(2.095903, 10),
                Arguments.of(-0.630930, 0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLog5Values")
    public void testLog5Integration(double expected, double value) {
        Log5 log5 = new Log5(ln);
        when(ln.calculate(5)).thenReturn(1.609437912);
        Assertions.assertEquals(expected, log5.calculate(value), DELTA);
    }

    private static Stream<Arguments> provideLog5Values() {
        return Stream.of(
                Arguments.of(Double.NEGATIVE_INFINITY, 0),
                Arguments.of(0, 1),
                Arguments.of(1.4306765, 10),
                Arguments.of(-0.430677, 0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLog10Values")
    public void testLog10Integration(double expected, double value) {
        Log10 log10 = new Log10(ln);
        Assertions.assertEquals(expected, log10.calculate(value), DELTA);
    }

    private static Stream<Arguments> provideLog10Values() {
        return Stream.of(
                Arguments.of(Double.NEGATIVE_INFINITY, 0),
                Arguments.of(0, 1),
                Arguments.of(1, 10),
                Arguments.of(-0.301030, 0.5)
        );
    }
}
