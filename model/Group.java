package model;

import java.util.List;

public class Group {
    private List<Person> people;

    public Group(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }
}
