package com.example.nestpallybackend.controller;

import com.example.nestpallybackend.model.Apartment;
import com.example.nestpallybackend.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;

    @Autowired
    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    // Create a new apartment
    @PostMapping
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        Apartment savedApartment = apartmentService.saveApartment(apartment);
        return new ResponseEntity<>(savedApartment, HttpStatus.CREATED);
    }

    // Get all apartments
    @GetMapping
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    // Get an apartment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getApartmentById(@PathVariable Long id) {
        Optional<Apartment> apartment = apartmentService.getApartmentById(id);
        return apartment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an apartment
    @PutMapping("/{id}")
    public ResponseEntity<Apartment> updateApartment(@PathVariable Long id, @RequestBody Apartment apartment) {
        apartment.setId(id);
        Apartment updatedApartment = apartmentService.updateApartment(apartment);
        return new ResponseEntity<>(updatedApartment, HttpStatus.OK);
    }

    // Delete an apartment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}