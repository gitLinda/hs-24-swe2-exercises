package ch.juventus.recursion;

public class Palindrome {

    public static boolean isPalindrome(String input) {
        if(input.length() < 2) {
            return true;
        }

        input = input.toLowerCase();
        String firstCharacter = input.substring(0, 1);
        String lastCharacter = input.substring(input.length() - 1);

        if(firstCharacter.equals(lastCharacter)) {
            String substring = input.substring(1, input.length() - 1);
            return isPalindrome(substring);
        } else {
            return false;
        }
    }

}
