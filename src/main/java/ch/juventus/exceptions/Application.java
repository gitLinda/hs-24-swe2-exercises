package ch.juventus.exceptions;

public class Application {

    public static void main(String[] args) {

        PersonRepository personRepository = new PersonRepository();

        try {
            personRepository.findById(1);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        personRepository.addPerson(null);
    }
}
