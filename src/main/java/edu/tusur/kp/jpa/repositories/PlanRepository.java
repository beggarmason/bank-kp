package edu.tusur.kp.jpa.repositories;

import edu.tusur.kp.jpa.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
