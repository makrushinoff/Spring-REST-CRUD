package ua.andrij.spring.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import ua.andrij.spring.database.PeopleDB;
import ua.andrij.spring.models.Person;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@ComponentScan(basePackages = "ua.andrij.spring.database")
public class PersonDAO {

    private final PeopleDB database;

    public PersonDAO(PeopleDB database) {
        this.database = database;
    }

    public List<Person> getAllPeople() {
        return database.getAllPeople();
    }

    public void createPerson(Person person) {
        database.putPerson(person);
    }

    public Person getById(UUID id) {
        return database.findById(id);
    }

    public void updateByID(UUID id, Person person) {
        database.updateByID(id, person);
    }

    public void deleteByID(UUID id) {
        database.deleteById(id);
    }
}
