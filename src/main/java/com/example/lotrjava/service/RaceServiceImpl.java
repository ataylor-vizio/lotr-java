package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.entity.Race;
import com.example.lotrjava.repository.RaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RaceServiceImpl implements RaceService {

    RaceRepository raceRepository;

    @Override
    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

    @Override
    public List<Race> getRaces() {
        return (List<Race>) raceRepository.findAll();
    }

    @Override
    public Race getRace(String raceName) {
        return raceRepository.findRaceByRaceName(raceName).orElseThrow();
    }

    @Override
    public Race updateRace(String raceName, Race race) {
        Race existingRace = raceRepository.findRaceByRaceName(raceName).orElseThrow();
        existingRace.setRaceName(raceName);
        existingRace.setDescription(race.getDescription());
        existingRace.setLotrCharacterList(race.getLotrCharacterList());
        return raceRepository.save(existingRace);
    }

    @Override
    public List<LotrCharacter> getRaceMembers(String raceName) {
        return raceRepository.findRaceByRaceName(raceName).orElseThrow().getLotrCharacterList();
    }

    @Override
    public void deleteRace(String raceName) {
        raceRepository.deleteByRaceName(raceName);
    }
}
