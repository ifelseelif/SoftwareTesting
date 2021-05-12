import functions.trigonometric.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public class TrigonometricFunctionIntegrationTest {

    private static Sine sine;
    private static Cosine cosine;
    private static Tangent tangent;
    private static Cotangent cotangent;
    private static Secant secant;
    private static Cosecant cosecant;
    private static TrigonometricFunction trigonometricFunction;
    private final double DELTA = 0.001;

    @BeforeAll
    static void setUp() {
        sine = Mockito.mock(Sine.class);
        cosine = Mockito.mock(Cosine.class);
        tangent = Mockito.mock(Tangent.class);
        cotangent = Mockito.mock(Cotangent.class);
        secant = Mockito.mock(Secant.class);
        cosecant = Mockito.mock(Cosecant.class);

        trigonometricFunction = new TrigonometricFunction(sine, cosine, tangent, cotangent, secant, cosecant);

        when(sine.calculate(-1.57)).thenReturn(-0.999999683);
        when(cosine.calculate(-1.57)).thenReturn(0.0007963);
        when(tangent.calculate(-1.57)).thenReturn(-1255.77);
        when(cotangent.calculate(-1.57)).thenReturn(-0.0007963);
        when(secant.calculate(-1.57)).thenReturn(1255.77);
        when(cosecant.calculate(-1.57)).thenReturn(-1.00000032);

        when(sine.calculate(-1.4)).thenReturn(-0.9854497);
        when(cosine.calculate(-1.4)).thenReturn(0.169967);
        when(tangent.calculate(-1.4)).thenReturn(-5.79788);
        when(cotangent.calculate(-1.4)).thenReturn(-0.172477);
        when(secant.calculate(-1.4)).thenReturn(5.88349);
        when(cosecant.calculate(-1.4)).thenReturn(-1.014765);

        when(sine.calculate(-1.5)).thenReturn(-0.9974950);
        when(cosine.calculate(-1.5)).thenReturn(0.0707372);
        when(tangent.calculate(-1.5)).thenReturn(-14.1014);
        when(cotangent.calculate(-1.5)).thenReturn(-0.0709148);
        when(secant.calculate(-1.5)).thenReturn(14.1368);
        when(cosecant.calculate(-1.5)).thenReturn(-1.002511);
    }

    @ParameterizedTest
    @MethodSource("provideDoubleValues")
    public void testTrigonometricFunction(double expected, double value) {
        Assertions.assertEquals(expected, trigonometricFunction.calculate(value), DELTA);
    }

    private static Stream<Arguments> provideDoubleValues() {
        return Stream.of(
                Arguments.of(-0.0017288, -1.57),
                Arguments.of(-0.4537199, -1.4),
                Arguments.of(-0.1547946, -1.5)
        );
    }

    @Test
    public void testTrigonometricFunction_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> trigonometricFunction.calculate(0.8894d));
    }
}
