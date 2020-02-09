package edu.tusur.kp.jpa.repositories;

import edu.tusur.kp.jpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
