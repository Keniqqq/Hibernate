package ru.netology.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

public interface PersonRepository extends JpaRepository<Person, PersonId> {
}