package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.repository.AllianceRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Alliance getAlliance(Long id) {
        return allianceRepository.findById(id).orElseThrow();
    }

    @Override
    public List<LotrCharacter> getAllianceMembers(Long id) {
        List<LotrCharacter> members = allianceRepository.findById(id).orElseThrow().getLotrCharacters();
        return members;
    }

    @Override
    public Alliance updateAlliance(Long id, Alliance alliance) {
        Alliance existingAlliance = allianceRepository.findById(id).orElseThrow();
        existingAlliance.setAlliance_name(alliance.getAlliance_name());
        return allianceRepository.save(existingAlliance);
    }

    @Override
    public void deleteAlliance(Long id) {
       allianceRepository.delete(allianceRepository.findById(id).orElseThrow());
    }
}
