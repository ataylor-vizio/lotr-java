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

@AllArgsConstructor
@Service
public class LotrCharacterServiceImpl implements LotrCharacterService {

    LotrCharacterRepository lotrCharacterRepository;
    AllianceRepository allianceRepository;
    RaceRepository raceRepository;

    @Override
    public LotrCharacter createLotrCharacter(HashMap<String, String> lotrCharacterRequest) {
        LotrCharacter createdCharacter = new LotrCharacter();
        setCharacterInfo(createdCharacter, lotrCharacterRequest);
        return createdCharacter;
    }

    @Override
    public List<LotrCharacter> getLotrCharacters() {
       return (List<LotrCharacter>) lotrCharacterRepository.findAll();
    }

    @Override
    public LotrCharacter getLotrCharacter(Long id) {
        return lotrCharacterRepository.findById(id).orElseThrow();
    }

    @Override
    public LotrCharacter updateLotrCharacter(Long id, HashMap<String, String> lotrCharacterRequest) {
        LotrCharacter foundCharacter = lotrCharacterRepository.findById(id).orElseThrow();
        setCharacterInfo(foundCharacter, lotrCharacterRequest);
        return foundCharacter;
    }

    @Override
    public void deleteLotrCharacter(Long id) {
        lotrCharacterRepository.deleteById(id);
    }

    public void setCharacterInfo(LotrCharacter newOrChangedCharacter, HashMap<String, String> lotrCharacterRequest) {
        newOrChangedCharacter.setName(lotrCharacterRequest.get("name"));
        Race race = raceRepository.findRaceByRaceName(lotrCharacterRequest.get("race")).orElseThrow();
        newOrChangedCharacter.setRace(race);
        Alliance alliance = allianceRepository.findByAllianceName(lotrCharacterRequest.get("alliance")).orElseThrow();
        newOrChangedCharacter.setAlliance(alliance);
        lotrCharacterRepository.save(newOrChangedCharacter);
    }

}
