package ua.andrij.spring.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Person {

    private UUID id;

    @NotEmpty(message = "First name should not be empty!")
    @Size(min = 2, max = 30)
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    @Size(min = 2, max = 30)
    private String lastName;

    public Person(){}

    public Person(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
