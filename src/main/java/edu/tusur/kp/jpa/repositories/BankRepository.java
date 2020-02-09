package edu.tusur.kp.jpa.repositories;

import edu.tusur.kp.jpa.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
