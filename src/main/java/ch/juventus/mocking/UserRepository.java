package ch.juventus.mocking;

import java.util.List;

public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        users = List.of(
                new User("User1", 20, List.of("a", "b", "c", "d", "e", "f")),
                new User("User2", 20),
                new User("User3", 20),
                new User("User4", 20),
                new User("User5", 20),
                new User("User6", 20),
                new User("User7", 20),
                new User("User8", 20),
                new User("User9", 20)
        );
    }

    public List<User> getUsers() {
        return users;
    }
}
