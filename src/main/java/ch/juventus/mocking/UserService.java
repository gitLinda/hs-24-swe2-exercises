package ch.juventus.mocking;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getActiveUsers() {
        return userRepository.getUsers().stream()
                .filter(this::isActive)
                .toList();
    }

    public User findActiveUser(String name) {
        return userRepository.getUsers().stream()
                .filter(user -> user.getName().equals(name))
                .filter(this::isActive)
                .findFirst()
                .orElse(null);
    }

    public List<User> getAdultUsers() {
        return userRepository.getUsers().stream()
                .filter(user -> isOlderThan(user, 18))
                .toList();
    }

    public boolean isActive(User user) {
        return user.getActivities().size() >= 5;
    }

    public boolean isOlderThan(User user, int age) {
        return user.getAge() > age;
    }
}
