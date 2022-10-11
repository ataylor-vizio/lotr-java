package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public interface AllianceService {

    Alliance createAlliance(Alliance alliance);
    List<Alliance> getAlliances();
    Alliance getAlliance(String allianceName);
    Alliance updateAlliance(String allianceName, Alliance alliance);
    List<LinkedHashMap<String, String>> getAllianceMembers(String allianceName);
    void deleteAlliance(String allianceName);
}
