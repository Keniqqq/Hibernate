package ru.netology.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Person {
    @EmbeddedId
    private PersonId id;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Person() {}

    public Person(String name, String surname, int age, String cityOfLiving, String phoneNumber) {
        this.id = new PersonId(name, surname, age);
        this.cityOfLiving = cityOfLiving;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public PersonId getId() { return id; }
    public void setId(PersonId id) { this.id = id; }

    public String getCityOfLiving() { return cityOfLiving; }
    public void setCityOfLiving(String cityOfLiving) { this.cityOfLiving = cityOfLiving; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}