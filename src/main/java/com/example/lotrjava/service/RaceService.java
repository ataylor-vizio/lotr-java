package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.entity.Race;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RaceService {

    Race createRace(Race race);
    List<Race> getRaces();
    Race getRace(String race);
    Race updateRace(String raceName, Race race);
    List<LotrCharacter> getRaceMembers(String raceName);
    void deleteRace(String raceName);
}
