package com.example.nestpallybackend.service;

import com.example.nestpallybackend.model.Apartment;
import com.example.nestpallybackend.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    // Create a new apartment
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    // Get all apartments
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    // Get an apartment by ID
    public Optional<Apartment> getApartmentById(Long id) {
        return apartmentRepository.findById(id);
    }

    // Update an apartment
    public Apartment updateApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    // Delete an apartment by ID
    public void deleteApartment(Long id) {
        apartmentRepository.deleteById(id);
    }
}