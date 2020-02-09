package edu.tusur.kp.jpa.repositories;

import edu.tusur.kp.jpa.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
