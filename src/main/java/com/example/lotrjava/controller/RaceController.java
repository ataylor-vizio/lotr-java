package com.example.lotrjava.controller;

import com.example.lotrjava.entity.Race;
import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.service.RaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/races")
@RestController
public class RaceController {

    RaceService raceService;

    @GetMapping
    public ResponseEntity<List<Race>> getRaces() {
        return new ResponseEntity<>(raceService.getRaces(), HttpStatus.OK);
    }

    @GetMapping("/{raceName}")
    public ResponseEntity<Race> getRace(@PathVariable String raceName) {
        return new ResponseEntity<>(raceService.getRace(raceName), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        return new ResponseEntity<>(raceService.createRace(race), HttpStatus.CREATED);
    }

    @PutMapping("/{raceName}")
    public ResponseEntity<Race> updateRace(@PathVariable String raceName, @RequestBody Race race) {
        return new ResponseEntity<>(raceService.updateRace(raceName, race), HttpStatus.OK);
    }

    @DeleteMapping("/{raceName}")
    public ResponseEntity<HttpStatus> deleteRace(@PathVariable String raceName) {
        raceService.deleteRace(raceName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{raceName}/members")
    public ResponseEntity<List<LinkedHashMap<String, String>>> showRaceMembers(@PathVariable String raceName) {
        return new ResponseEntity<>(raceService.getRaceMembers(raceName), HttpStatus.OK);
    }
}
