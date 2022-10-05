package com.example.lotrjava.service;

import com.example.lotrjava.entity.Race;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RaceService {

    Race createRace(Race race);
    List<Race> getRaces();
    Race getRace(Long id);
    Race updateRace(Long id, Race race);
    void deleteRace(Long id);
}
