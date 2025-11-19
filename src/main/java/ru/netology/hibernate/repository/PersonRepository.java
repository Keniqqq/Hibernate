package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.entity.PersonId;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId>{

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAge(String name, String surname, int age);

    @Query("SELECT p FROM Person p WHERE p.id.age < :age ORDER BY p.id.age ASC")
    List<Person> findPersonsByAgeLessThanOrderByAge(@Param("age") int age);

    Optional<Person> findByIdNameAndIdSurname(String name, String surname);
}