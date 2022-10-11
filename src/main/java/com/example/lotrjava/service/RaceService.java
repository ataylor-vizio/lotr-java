package com.example.lotrjava.service;


import com.example.lotrjava.entity.Race;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;

@Service
public interface RaceService {

    Race createRace(Race race);
    List<Race> getRaces();
    Race getRace(String race);
    Race updateRace(String raceName, Race race);
    List<LinkedHashMap<String, String>> getRaceMembers(String raceName);
    void deleteRace(String raceName);
}
