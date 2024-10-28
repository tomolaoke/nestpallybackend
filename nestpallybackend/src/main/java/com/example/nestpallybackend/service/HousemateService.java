package com.example.nestpallybackend.service;

import com.example.nestpallybackend.service.HousemateService;
import com.example.nestpallybackend.model.Housemate;
import java.util.List;
import java.util.Optional;

public interface HousemateService {
    Housemate saveHousemate(Housemate housemate);
    List<Housemate> getAllHousemates();
    Optional<Housemate> getHousemateById(Long id);
    Housemate updateHousemate(Housemate housemate);
    void deleteHousemate(Long id);
}