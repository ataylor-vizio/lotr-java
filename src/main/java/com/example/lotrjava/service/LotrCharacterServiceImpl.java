package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.entity.Race;
import com.example.lotrjava.repository.AllianceRepository;
import com.example.lotrjava.repository.LotrCharacterRepository;
import com.example.lotrjava.repository.RaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class LotrCharacterServiceImpl implements LotrCharacterService {

    LotrCharacterRepository lotrCharacterRepository;
    AllianceRepository allianceRepository;
    RaceRepository raceRepository;

    @Override
    public LotrCharacter createLotrCharacter(String char_name, String alliance_id, String race_id) {
        LotrCharacter createdChar = new LotrCharacter();
        createdChar.setRace(raceRepository.findById(Long.parseLong(race_id)).orElseThrow());
        createdChar.setAlliance(allianceRepository.findById(Long.parseLong(alliance_id)).orElseThrow());
        createdChar.setChar_name(char_name);
        lotrCharacterRepository.save(createdChar);
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
    public LotrCharacter updateLotrCharacter(Long id, LotrCharacter lotrCharacter) {
        LotrCharacter foundCharacter = lotrCharacterRepository.findById(id).orElseThrow();
        foundCharacter.setChar_name(lotrCharacter.getChar_name());
        foundCharacter.setAlliance(lotrCharacter.getAlliance());
        foundCharacter.setRace(lotrCharacter.getRace());
        return foundCharacter;
    }

    @Override
    public void deleteLotrCharacter(Long id) {
        lotrCharacterRepository.deleteById(id);
    }

//    public void setCharacterInfo(LotrCharacter newOrChangedCharacter, HashMap<String, String> charParams) {
//        newOrChangedCharacter.setName(charParams.get("name"));
//        Race race = raceRepository.findById().get("race")).orElseThrow();
//        newOrChangedCharacter.setRace(race);
//        Alliance alliance = allianceRepository.findByAllianceName(charParams.get("alliance")).orElseThrow();
//        newOrChangedCharacter.setAlliance(alliance);
//        lotrCharacterRepository.save(newOrChangedCharacter);
//    }

}
