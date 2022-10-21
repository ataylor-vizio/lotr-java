package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.repository.AllianceRepository;
import com.example.lotrjava.repository.LotrCharacterRepository;
import com.example.lotrjava.repository.RaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LotrCharacterServiceImpl implements LotrCharacterService {

    LotrCharacterRepository lotrCharacterRepository;
    AllianceRepository allianceRepository;
    RaceRepository raceRepository;

    @Override
    public LotrCharacter createLotrCharacter(String char_name, String alliance_id, String race_id) {
        LotrCharacter createdChar = new LotrCharacter();
        setCharacterInfo(createdChar, char_name, alliance_id, race_id);
        return createdChar;
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
    public LotrCharacter updateLotrCharacter(Long id, String char_name, String alliance_id, String race_id) {
        LotrCharacter updatedCharacter = lotrCharacterRepository.findById(id).orElseThrow();
        setCharacterInfo(updatedCharacter, char_name, alliance_id, race_id);
        return updatedCharacter;
    }

    @Override
    public void deleteLotrCharacter(Long id) {
        lotrCharacterRepository.deleteById(id);
    }

    public void setCharacterInfo(LotrCharacter newOrUpdatedCharacter, String char_name, String alliance_id, String race_id) {
        newOrUpdatedCharacter.setRace(raceRepository.findById(Long.parseLong(race_id)).orElseThrow());
        newOrUpdatedCharacter.setAlliance(allianceRepository.findById(Long.parseLong(alliance_id)).orElseThrow());
        newOrUpdatedCharacter.setChar_name(char_name);
        lotrCharacterRepository.save(newOrUpdatedCharacter);
    }
}
