package ch.juventus.javadoc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    public void setup() {
        mathUtils = new MathUtils();
    }

    @ParameterizedTest
    @MethodSource("provideAdditionInputs")
    void testAdditionWithTwoEntryList(double a, double b, double expected) {
        // given
        List<Double> numbers = new ArrayList<>();
        numbers.add(a);
        numbers.add(b);
        // when
        double result = mathUtils.addition(numbers);
        // then
        assertEquals(expected, result, "Calculation result wrong");
    }

    private static Stream<Arguments> provideAdditionInputs() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(25, 76, 101),
                Arguments.of(0, -50, -50)
        );
    }

    @Test
    void testAdditionWithThreeEntryList() {
        // given
        List<Double> numbers = new ArrayList<>();
        numbers.add(5d);
        numbers.add(6.5d);
        numbers.add(9.5d);
        // when
        double result = mathUtils.addition(numbers);
        // then
        assertEquals(21, result, "Calculation result wrong");
    }

    @Test
    void testAdditionWithSingleEntryList() {
        // given
        List<Double> numbers = new ArrayList<>();
        numbers.add(5d);
        // when
        double result = mathUtils.addition(numbers);
        // then
        assertEquals(5d, result, "Calculation result wrong");
    }

    @Test
    void testAdditionWithZeroEntryList() {
        // given
        List<Double> numbers = new ArrayList<>();
        // when
        double result = mathUtils.addition(numbers);
        // then
        assertEquals(0d, result, "Calculation result wrong");
    }

    @Test
    void additionWithNullParameterShouldThrowNullPointer() {
        assertThrows(
                NullPointerException.class,
                () -> mathUtils.addition(null),
                "Did not throw exception"
        );
    }

    @Test
    void tenMinusTwoShouldEqualsEight() {
        // when
        double result = mathUtils.subtraction(10d, 2d);
        // then
        assertEquals(8d, result, "Calculation result wrong");
    }

    @Test
    void zeroMinusFiveShouldEqualMinusFive() {
        // when
        double result = mathUtils.subtraction(0d, 5d);
        // then
        assertEquals(-5d, result, "Calculation result wrong");
    }

    @Test
    void minusTenMinusFiveShouldEqualMinusFifteen() {
        // when
        double result = mathUtils.subtraction(-10d, 5d);
        // then
        assertEquals(-15d, result, "Calculation result wrong");
    }

    @Test
    void minusTenMinusMinusFiveShouldEqualMinusFive() {
        // when
        double result = mathUtils.subtraction(-10d, -5d);
        // then
        assertEquals(-5d, result, "Calculation result wrong");
    }

    // todo multiplication tests
    // todo division tests

}