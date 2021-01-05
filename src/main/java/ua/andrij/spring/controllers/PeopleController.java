package ua.andrij.spring.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.andrij.spring.dao.PersonDAO;
import ua.andrij.spring.models.Person;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/people")
@ComponentScan(basePackages = "ua.andrij.spring.dao")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/")
    public List<Person> getAllPeople() {
        return personDAO.getAllPeople();
    }

    @PostMapping("/")
    public void createPerson(@RequestBody Person person) {
        personDAO.createPerson(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable UUID id) {
        return personDAO.getById(id);
    }

    @PatchMapping("/{id}")
    public void updatePersonById(@PathVariable UUID id, @RequestBody Person person) {
        personDAO.updateByID(id, person);
    }

    @DeleteMapping("/{id}")
    public void deletePersonByID(@PathVariable UUID id) {
        personDAO.deleteByID(id);
    }
}
