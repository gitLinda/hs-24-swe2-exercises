package ch.juventus.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
