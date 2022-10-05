package com.example.lotrjava.service;

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
        return null;
    }

    @Override
    public void deleteRace(Long id) {
        raceRepository.deleteById(id);
    }
}
