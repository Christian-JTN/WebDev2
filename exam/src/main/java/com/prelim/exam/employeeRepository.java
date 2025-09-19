package com.prelim.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface employeeRepository extends JpaRepository<employee, Long> {
    Optional<employee> findByEmail(String email);
    boolean existsByEmail(String email);
}
