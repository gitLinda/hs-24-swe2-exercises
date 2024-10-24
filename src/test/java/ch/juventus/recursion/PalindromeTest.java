package ch.juventus.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @ParameterizedTest
    @MethodSource("palindromeTestData")
    public void testIsPalindrome(String input, boolean expectedReturn) {
        boolean result = Palindrome.isPalindrome(input);
        assertEquals(expectedReturn, result);
    }

    private static Stream<Arguments> palindromeTestData() {
        return Stream.of(
                Arguments.of("Anna", true),
                Arguments.of("Korb", false),
                Arguments.of("Bob", true),
                Arguments.of("Mein Computer", false),
                Arguments.of("Level", true),
                Arguments.of("Fuss", false),
                Arguments.of("Anna Bob Anna", true),
                Arguments.of("Kamel und Stein", false),
                Arguments.of("!+Level+!", true)
        );
    }

}