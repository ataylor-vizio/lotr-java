package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AllianceService {

    Alliance createAlliance(Alliance alliance);
    List<Alliance> getAlliances();
    Optional<Alliance> getAlliance(Long id);
    Alliance updateAlliance(Long id, Alliance alliance);
    void deleteAlliance(Long id);
}
