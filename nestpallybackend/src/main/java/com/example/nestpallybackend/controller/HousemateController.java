package com.example.nestpallybackend.controller;

import com.example.nestpallybackend.model.Housemate;
import com.example.nestpallybackend.service.HousemateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/housemates")
public class HousemateController {

    private final HousemateService housemateService;

    @Autowired
    public HousemateController(HousemateService housemateService) {
        this.housemateService = housemateService;
    }

    @PostMapping
    public ResponseEntity<Housemate> createHousemate(@RequestBody Housemate housemate) {
        Housemate savedHousemate = housemateService.saveHousemate(housemate);
        return new ResponseEntity<>(savedHousemate, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Housemate> getAllHousemates() {
        return housemateService.getAllHousemates();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Housemate> getHousemateById(@PathVariable Long id) {
        Optional<Housemate> housemate = housemateService.getHousemateById(id);
        return housemate.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Housemate> updateHousemate(@PathVariable Long id, @RequestBody Housemate housemate) {
        housemate.setId(id);
        Housemate updatedHousemate = housemateService.updateHousemate(housemate);
        return new ResponseEntity<>(updatedHousemate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHousemate(@PathVariable Long id) {
        housemateService.deleteHousemate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}