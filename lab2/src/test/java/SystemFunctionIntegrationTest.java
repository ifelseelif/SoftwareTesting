import functions.FunctionSystem;
import functions.logarithm.LogarithmFunction;
import functions.trigonometric.TrigonometricFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class SystemFunctionIntegrationTest {

    private static FunctionSystem functionSystem;
    private final double DELTA = 0.00001;

    @BeforeAll
    static void setUp() {
        TrigonometricFunction trigonometricFunction = Mockito.mock(TrigonometricFunction.class);
        LogarithmFunction logarithmFunction = Mockito.mock(LogarithmFunction.class);
        functionSystem = new FunctionSystem(trigonometricFunction, logarithmFunction);

        when(trigonometricFunction.calculate(-1.57)).thenReturn(-0.0017288);
        when(trigonometricFunction.calculate(-1.25000)).thenReturn(-1.4111092);

        when(logarithmFunction.calculate(0.6)).thenReturn(-4.4832693);
        when(logarithmFunction.calculate(10)).thenReturn(-3.6507030);
    }

    @ParameterizedTest
    @MethodSource("provideDouble")
    public void testSystemFunction(double expected, double value) {
        Assertions.assertEquals(expected, functionSystem.calculate(value), DELTA);
    }

    private static Stream<Arguments> provideDouble() {
        return Stream.of(
                Arguments.of(-3.6507030, 10),
                Arguments.of(-4.4832693, 0.6),
                Arguments.of(-0.0017288, -1.57),
                Arguments.of(-0.0017288, -1.57)
        );
    }

}
