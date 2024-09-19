package ch.juventus.collections;

import ch.juventus.object.Person;

import java.util.*;

public class CollectionsSolution {

    public static void main(String[] args) {
        arrayList();
        linkedList();
        hashSet();
        linkedHashSet();
        treeSet();
        hashMap();
        linkedHashMap();
        treeMap();
        loops();
    }

    static void arrayList() {
        List<String> animals = new ArrayList<>();
        animals.add("Hund");
        animals.add("Katze");
        animals.add("Katze");
        animals.add("Maus");
        animals.add("Vogel");

        System.out.println(animals.size());

        animals.add(2, "Fisch");

        System.out.println(animals);

        System.out.println(animals.contains("Maus"));

        System.out.println(animals.get(0));

        animals.remove(3);
        animals.remove("Vogel");

        animals.clear();
    }

    static void linkedList() {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Hund");
        animals.add("Katze");
        animals.add("Katze");
        animals.add("Maus");
        animals.add("Vogel");

        System.out.println(animals.size());

        System.out.println(animals.indexOf("Vogel"));
        System.out.println(animals.indexOf("Einhorn"));

        System.out.println(animals.get(1));

        System.out.println(animals.getFirst());
        System.out.println(animals.getLast());

        System.out.println(animals.removeFirst());
        System.out.println(animals.removeLast());

    }

    static void hashSet() {
        Set<Person> people = new HashSet<>();
        people.add(new Person("Hans", "Meier"));
        people.add(new Person("Hans", "Meier"));
        people.add(new Person("Peter", "Müller"));
        people.add(new Person("Anna", "Gerber"));
        people.add(new Person("Lisa", "Muster"));

        System.out.println(people.isEmpty());

        System.out.println(people.size());

        System.out.println(people.contains(new Person("Peter", "Müller")));

        people.remove(new Person("Anna", "Gerber"));

        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
    }

    static void linkedHashSet() {
        Set<Person> people = new LinkedHashSet<>();
        people.add(new Person("Hans", "Meier"));
        people.add(new Person("Hans", "Meier"));
        people.add(new Person("Peter", "Müller"));
        people.add(new Person("Anna", "Gerber"));
        people.add(new Person("Lisa", "Muster"));

        System.out.println(people.isEmpty());

        System.out.println(people.size());

        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
        System.out.println(people);
    }

    static void treeSet() {
        Set<Person> people = new TreeSet<>(Comparator.comparing(Person::getLastName));
        people.add(new Person("Hans", "Meier"));
        people.add(new Person("Hans", "Meier"));
        people.add(new Person("Peter", "Müller"));
        people.add(new Person("Anna", "Gerber"));
        people.add(new Person("Lisa", "Muster"));

        System.out.println(people.size());

        System.out.println(people);
    }

    static void hashMap() {
        Map<String, List<Person>> people = new HashMap<>();
        List<Person> family = List.of(
                new Person("Lisa", "Muster"),
                new Person("Robert", "Muster"),
                new Person("Claudia", "Muster")
        );
        List<Person> friends = List.of(
                new Person("Hans", "Meier"),
                new Person("Peter", "Müller"),
                new Person("Michael", "Gerber")
        );
        people.put("family", family);
        people.put("office", null);
        people.put("friends", friends);

        System.out.println(people);

        List<Person> office = List.of(
                new Person("Lea", "Fischer"),
                new Person("Amelie", "Kuster")
        );
        people.put("office", office);

        System.out.println(people.entrySet());
        System.out.println(people.keySet());
        System.out.println(people.values());
    }

    static void linkedHashMap() {
        Map<Integer, Person> people = new LinkedHashMap<>(10, 0.75f, true);
        people.put(1, new Person("First", "Person"));
        people.put(2, new Person("Second", "Person"));
        people.put(3, new Person("Third", "Person"));
        people.put(1, new Person("FirstV2", "Person"));
        people.put(4, new Person("Forth", "Person"));

        System.out.println(people);

        people.get(2);
        people.get(4);

        System.out.println(people);
    }

    static void treeMap() {
        Map<Integer, Person> people = new TreeMap<>();
        people.put(4, new Person("Forth", "Person"));
        people.put(2, new Person("Second", "Person"));
        people.put(1, new Person("First", "Person"));
        people.put(3, new Person("Third", "Person"));
        people.put(1, new Person("FirstV2", "Person"));

        System.out.println(people);
    }

    static void loops() {
        listLoop();
        setLoop();
        mapLoop();
    }

    static void listLoop() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    static void setLoop() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);

        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    static void mapLoop() {
        Map<Integer, String> numbers = Map.of(
                1, "One",
                2, "Two",
                3, "Three"
        );

        for (Map.Entry<Integer, String> entry : numbers.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for (Integer key : numbers.keySet()) {
            System.out.println(key);
        }

        for (String value : numbers.values()) {
            System.out.println(value);
        }
    }

}
