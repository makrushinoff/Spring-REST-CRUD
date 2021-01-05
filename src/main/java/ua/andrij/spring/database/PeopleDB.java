package ua.andrij.spring.database;

import org.springframework.stereotype.Repository;
import ua.andrij.spring.models.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class PeopleDB {
    private List<Person> personList;

    public PeopleDB(){
        personList = new ArrayList<>();
        personList.add(new Person(UUID.randomUUID(), "Andrij", "Makrushin"));
    }

    public List<Person> getAllPeople() {
        return personList;
    }

    public void putPerson(Person person) {
        person.setId(UUID.randomUUID());
        personList.add(person);
    }

    public Person findById(UUID id) {
        return personList.stream()
                .filter(person -> person.getId() == id)
                .collect(Collectors.toList()).get(0);

    }

    public void updateByID(UUID id, Person person) {
        personList.removeIf(pers -> pers.getId().equals(id));
        person.setId(id);
        personList.add(person);
    }

    public void deleteById(UUID id) {
        boolean b = personList.removeIf(pers -> pers.getId().equals(id));
        System.out.println(b);
    }
}
