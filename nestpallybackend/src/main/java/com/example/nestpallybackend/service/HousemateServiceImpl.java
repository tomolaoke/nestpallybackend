package com.example.nestpallybackend.service;

import com.example.nestpallybackend.model.Housemate;
import com.example.nestpallybackend.repository.HousemateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HousemateServiceImpl implements HousemateService {

    private final HousemateRepository housemateRepository;

    @Autowired
    public HousemateServiceImpl(HousemateRepository housemateRepository) {
        this.housemateRepository = housemateRepository;
    }

    @Override
    public Housemate saveHousemate(Housemate housemate) {
        return housemateRepository.save(housemate);
    }

    @Override
    public List<Housemate> getAllHousemates() {
        return housemateRepository.findAll();
    }

    @Override
    public Optional<Housemate> getHousemateById(Long id) {
        return housemateRepository.findById(id);
    }

    @Override
    public Housemate updateHousemate(Housemate housemate) {
        return housemateRepository.save(housemate);
    }

    @Override
    public void deleteHousemate(Long id) {
        housemateRepository.deleteById(id);
    }
}