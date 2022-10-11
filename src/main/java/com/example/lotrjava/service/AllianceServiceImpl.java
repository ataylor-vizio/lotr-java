package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.repository.AllianceRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.StringMap;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Alliance getAlliance(String allianceName) {
        return allianceRepository.findByAllianceName(allianceName).orElseThrow();
    }

    @Override
    public Alliance findByAlliance(String allianceName) {
        return allianceRepository.findByAllianceName(allianceName).orElseThrow();
    }

    @Override
    public List<LotrCharacter> getAllianceMembers(String allianceName) {
        List<LotrCharacter> members = allianceRepository.findByAllianceName(allianceName).orElseThrow().getLotrCharacters();
        Map<String, String> map = new HashMap<>()
                for(LotrCharacter lotrCharacter in members) {
                    if
        }//TODO figure out how to not include whole race info in race response json
    }

    @Override
    public Alliance updateAlliance(String allianceName, Alliance alliance) {
        Alliance existingAlliance = allianceRepository.findByAllianceName(allianceName).orElseThrow();
        existingAlliance.setAllianceName(alliance.getAllianceName());
        return allianceRepository.save(existingAlliance);
    }

    @Override
    public void deleteAlliance(String allianceName) {
        allianceRepository.deleteAllianceByAllianceName(allianceName);
    }
}
