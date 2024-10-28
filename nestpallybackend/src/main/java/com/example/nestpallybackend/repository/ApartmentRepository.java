package com.example.nestpallybackend.repository;

import com.example.nestpallybackend.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    // Add custom query methods if needed
}