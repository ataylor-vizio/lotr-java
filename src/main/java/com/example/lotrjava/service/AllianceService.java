package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public interface AllianceService {

    Alliance createAlliance(Alliance alliance);
    List<Alliance> getAlliances();
    Alliance getAlliance(Long id);
    Alliance updateAlliance(Long id, Alliance alliance);
//    List<LinkedHashMap<String, String>> getAllianceMembers(Long id);
    void deleteAlliance(Long id);
}
