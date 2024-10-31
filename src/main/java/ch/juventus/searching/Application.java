package ch.juventus.searching;

import ch.juventus.object.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        Map<Person, String> personPhoneMap = new HashMap<>();
        personPhoneMap.put(new Person("Hans", "Muster"), "0791234567");
        personPhoneMap.put(new Person("Peter", "Keller"), "0798901234");
        personPhoneMap.put(new Person("Peter", "Kuster"), "0795678901");
        personPhoneMap.put(new Person("Lisa", "Muster"), "0792345678");
        personPhoneMap.put(new Person("Anna", "Meier"), "0792345678");

        System.out.println(findFirstByPhoneNumber(personPhoneMap, "0798901234"));
        System.out.println(findFirstByPhoneNumber(personPhoneMap, "000"));

        System.out.println(findAllByPhoneNumber(personPhoneMap, "0792345678"));
        System.out.println(findAllByPhoneNumber(personPhoneMap, "000"));
    }

    private static Person findFirstByPhoneNumber(Map<Person, String> personPhoneMap, String phoneNumber) {
        if(personPhoneMap.containsValue(phoneNumber)) {
            for (Map.Entry<Person,String> entry : personPhoneMap.entrySet()) {
                if(entry.getValue().equals(phoneNumber)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private static List<Person> findAllByPhoneNumber(Map<Person, String> personPhoneMap, String phoneNumber) {
        List<Person> people = new ArrayList<>();
        if(personPhoneMap.containsValue(phoneNumber)) {
            for (Map.Entry<Person,String> entry : personPhoneMap.entrySet()) {
                if(entry.getValue().equals(phoneNumber)) {
                    people.add(entry.getKey());
                }
            }
        }
        return people;
    }

}
