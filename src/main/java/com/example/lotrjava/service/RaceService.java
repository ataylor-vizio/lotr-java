package com.example.lotrjava.service;


import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.entity.Race;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;

@Service
public interface RaceService {

    Race createRace(Race race);
    List<Race> getRaces();
    Race getRace(Long id);
    Race updateRace(Long id, Race race);
    List<LotrCharacter> getRaceMembers(Long id);
    void deleteRace(Long id);
}
