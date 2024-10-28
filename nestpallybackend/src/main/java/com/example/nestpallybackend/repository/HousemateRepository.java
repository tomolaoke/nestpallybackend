package com.example.nestpallybackend.repository;

import com.example.nestpallybackend.model.Housemate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousemateRepository extends JpaRepository<Housemate, Long> {
    // Add custom query methods if needed
}