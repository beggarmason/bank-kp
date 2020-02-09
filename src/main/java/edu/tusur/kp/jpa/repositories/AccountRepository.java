package edu.tusur.kp.jpa.repositories;

import edu.tusur.kp.jpa.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
