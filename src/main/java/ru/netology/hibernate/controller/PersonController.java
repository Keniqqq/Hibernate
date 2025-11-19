package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    // GET /persons/by-city?city=Moscow
    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }

    // GET /persons/by-age?age=30
    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return repository.findPersonsByAgeLessThanOrderByAge(age);
    }

    // GET /persons/by-name-surname?name=Ivan&surname=Ivanov
    @GetMapping("/persons/by-name-surname")
    public Optional<Person> getPersonByNameAndSurname(
            @RequestParam String name,
            @RequestParam String surname) {
        return repository.findByIdNameAndIdSurname(name, surname);
    }
}