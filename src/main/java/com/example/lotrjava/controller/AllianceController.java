package com.example.lotrjava.controller;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.repository.AllianceRepository;
import com.example.lotrjava.service.AllianceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequestMapping("/alliances")
@RestController
public class AllianceController {

    AllianceService allianceService;
    AllianceRepository allianceRepository;

    @GetMapping
    public ResponseEntity<List<Alliance>> getAlliances() {
        return new ResponseEntity<>(allianceService.getAlliances(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Alliance>> getAlliance(@PathVariable Long id) {
        return new ResponseEntity<>(allianceService.getAlliance(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Alliance> createAlliance(@RequestBody Alliance alliance) {
        return new ResponseEntity<>(allianceService.createAlliance(alliance), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alliance> updateAlliance(@PathVariable Long id, @RequestBody Alliance alliance) {
        return new ResponseEntity<>(allianceService.updateAlliance(id, alliance), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAlliance(@PathVariable Long id) {
        allianceService.deleteAlliance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/members")
    public ResponseEntity<List<LotrCharacter>> showAllianceMembers(@PathVariable Long id) {
        return new ResponseEntity<>(allianceRepository.findById(id).get().getLotrCharacters(), HttpStatus.OK);
    }
}