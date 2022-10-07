package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.repository.AllianceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AllianceServiceImpl implements AllianceService {

    AllianceRepository allianceRepository;

    @Override
    public Alliance createAlliance(Alliance alliance) {
        return allianceRepository.save(alliance);
    }

    @Override
    public List<Alliance> getAlliances() {
        return (List<Alliance>) allianceRepository.findAll();
    }

    @Override
    public Optional<Alliance> getAlliance(Long id) {
        return Optional.of(allianceRepository.findById(id).orElseThrow());
    }

    @Override
    public Alliance findByAllianceName(String allianceName) {
        return allianceRepository.findByAlliance_nameIs(allianceName).orElseThrow();
    }

    @Override
    public Alliance updateAlliance(Long id, Alliance alliance) {
        Alliance existingAlliance = Optional.of(allianceRepository.findById(id).orElseThrow()).get();
        existingAlliance.setAlliance(alliance.getAlliance());
        return allianceRepository.save(existingAlliance);
    }

    @Override
    public void deleteAlliance(Long id) {
        allianceRepository.deleteById(id);
    }
}
