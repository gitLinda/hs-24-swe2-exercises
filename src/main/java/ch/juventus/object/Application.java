package ch.juventus.object;

public class Application {

    public static void main(String[] args) {

        Person linda = new Person(
                "linda",
                "krueger",
                new Address("heimstrasse", 8, 8952, "dietikon"),
                31,
                false
        );

        Person lindaCopy = new Person(
                "linda",
                "krueger",
                new Address("heimstrasse", 8, 8952, "dietikon"),
                31,
                false
        );

        System.out.println(linda.equals(lindaCopy));

    }
}
