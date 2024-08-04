import controller.Controller;
import model.Group;
import model.Person;
import model.Stream;
import service.PersonService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Создание объектов Person
        Person p1 = new Person("Alice", sdf.parse("1990-01-01"));
        Person p2 = new Person("Bob", sdf.parse("1985-05-23"));
        Person p3 = new Person("Charlie", sdf.parse("1992-07-12"));

        // Создание объектов Group
        Group g1 = new Group(Arrays.asList(p1, p2));
        Group g2 = new Group(Arrays.asList(p3));

        // Создание объектов Stream
        Stream s1 = new Stream(Arrays.asList(g1));
        Stream s2 = new Stream(Arrays.asList(g1, g2));

        // Создание контроллера
        Controller controller = new Controller();

        // Список потоков
        List<Stream> streams = Arrays.asList(s2, s1);

        // Сортировка потоков
        controller.sortStreams(streams);

        // Вывод отсортированных потоков
        for (Stream stream : streams) {
            System.out.println("Stream with " + stream.getGroups().size() + " groups.");
        }

        // Сортировка списка людей по имени и дате рождения
        PersonService personService = new PersonService();
        List<Person> people = Arrays.asList(p1, p2, p3);

        System.out.println("Before sorting by name:");
        people.forEach(person -> System.out.println(person.getName()));

        personService.sortPeopleByName(people);

        System.out.println("\nAfter sorting by name:");
        people.forEach(person -> System.out.println(person.getName()));

        System.out.println("\nBefore sorting by birth date:");
        people.forEach(person -> System.out.println(person.getBirthDate()));

        personService.sortPeopleByBirthDate(people);

        System.out.println("\nAfter sorting by birth date:");
        people.forEach(person -> System.out.println(person.getBirthDate()));
    }
}
