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
    public Race getRace(Long id) {
        return raceRepository.findById(id).orElseThrow();
    }

    @Override
    public Race updateRace(Long id, Race race) {
        Race existingRace = raceRepository.findById(id).orElseThrow();
        existingRace.setRace_name(existingRace.getRace_name());
        existingRace.setDescription(race.getDescription());
        existingRace.setLotrCharacterList(race.getLotrCharacterList());
        return raceRepository.save(existingRace);
    }

    @Override
    public List<LotrCharacter> getRaceMembers(Long id) {
        Race race = raceRepository.findById(id).orElseThrow();
        return race.getLotrCharacterList();
    }

    @Override
    public void deleteRace(Long id) {
        raceRepository.delete(raceRepository.findById(id).orElseThrow());
    }
}
