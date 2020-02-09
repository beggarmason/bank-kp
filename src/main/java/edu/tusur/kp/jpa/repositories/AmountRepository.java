package edu.tusur.kp.jpa.repositories;

import edu.tusur.kp.jpa.model.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmountRepository extends JpaRepository<Amount, Long> {
}
