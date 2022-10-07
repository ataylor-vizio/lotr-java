package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.entity.Race;
import com.example.lotrjava.repository.AllianceRepository;
import com.example.lotrjava.repository.LotrCharacterRepository;
import com.example.lotrjava.repository.RaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LotrCharacterServiceImpl implements LotrCharacterService {

    LotrCharacterRepository lotrCharacterRepository;
    AllianceRepository allianceService;
    RaceRepository raceRepository;

    @Override
    public LotrCharacter createLotrCharacter(HashMap<String, String> lotrCharacter) {
        LotrCharacter createdCharacter = new LotrCharacter();
        createdCharacter.setName(lotrCharacter.get("name"));
        Race race = raceRepository.findRaceByRace(lotrCharacter.get("race")).orElseThrow();
        createdCharacter.setRace(race);
        Alliance alliance = allianceService.findByAlliance_nameIs(lotrCharacter.get("alliance")).orElseThrow();
        createdCharacter.setAlliance(alliance);
        return lotrCharacterRepository.save(createdCharacter);
    }

    @Override
    public List<LotrCharacter> getLotrCharacters() {
       return (List<LotrCharacter>) lotrCharacterRepository.findAll();
    }

    @Override
    public Optional<LotrCharacter> getLotrCharacter(Long id) {
        return Optional.of(lotrCharacterRepository.findById(id).orElseThrow());
    }

    @Override
    public LotrCharacter updateLotrCharacter(Long id, LotrCharacter lotrCharacter) {
        Optional<LotrCharacter> existingCharacter = Optional.of(lotrCharacterRepository.findById(id).orElseThrow());
        LotrCharacter updatedLotrCharacter = existingCharacter.get();
        updatedLotrCharacter.setAlliance(lotrCharacter.getAlliance());
        updatedLotrCharacter.setName(lotrCharacter.getName());
        updatedLotrCharacter.setRace(lotrCharacter.getRace());
        lotrCharacterRepository.save(updatedLotrCharacter);
        return updatedLotrCharacter;
    }

    @Override
    public void deleteLotrCharacter(Long id) {
        lotrCharacterRepository.deleteById(id);
    }
}
