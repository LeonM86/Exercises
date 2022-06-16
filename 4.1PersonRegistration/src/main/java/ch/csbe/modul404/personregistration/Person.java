package ch.csbe.modul404.personregistration;

import javafx.event.ActionEvent;

public class Person extends ActionEvent {
    private String firstName;
    private String lastName;
    private String description;
    private String age;
    public Person() {
        this.firstName = getFirstName();
        this.lastName = getLastName();
        this.description = getDescription();
        this.age = getAge();
    }

    public Person(String firstName, String lastName, String description, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

