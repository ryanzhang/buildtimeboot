package org.acme;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
public class Person {
    String name;
    String gender;

    public Person() {
        this.name = "Ryan";
        this.gender= "male";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
