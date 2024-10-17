package ch.juventus.exceptions;

import ch.juventus.object.Person;

public class PersonRepository {

    public Person findById(int id) throws PersonNotFoundException {
        throw new PersonNotFoundException("Person with id " + id + " not found");
    }

    public void addPerson(Person person) {
        throw new IllegalArgumentException("I don't like this guy");
    }
}
