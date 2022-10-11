package com.example.lotrjava.repository;

import com.example.lotrjava.entity.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends CrudRepository<Race, Long> {
    Optional<Race> findRaceByRaceName(String raceName);
    void deleteByRaceName(String raceName);
}