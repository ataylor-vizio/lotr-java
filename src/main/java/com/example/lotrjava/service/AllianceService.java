package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.entity.LotrCharacter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AllianceService {

    Alliance createAlliance(Alliance alliance);
    List<Alliance> getAlliances();
    Alliance getAlliance(String allianceName);
    Alliance findByAlliance(String allianceName);
    Alliance updateAlliance(String allianceName, Alliance alliance);
    List<LotrCharacter> getAllianceMembers(String allianceName);
    void deleteAlliance(String allianceName);
}
