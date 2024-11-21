package ch.juventus.mocking;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;
    private final int age;
    private final List<String> activities;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.activities = new ArrayList<String>();
    }

    public User(String name, int age, List<String> activities) {
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }
}
