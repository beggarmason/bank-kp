package edu.tusur.kp.jpa.repositories;

import edu.tusur.kp.jpa.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
