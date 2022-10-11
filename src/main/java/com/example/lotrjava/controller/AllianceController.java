package com.example.lotrjava.controller;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.service.AllianceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/alliances")
@RestController
public class AllianceController {

    AllianceService allianceService;

    @GetMapping
    public ResponseEntity<List<Alliance>> getAlliances() {
        return new ResponseEntity<>(allianceService.getAlliances(), HttpStatus.OK);
    }

    @GetMapping("/{allianceName}")
    public ResponseEntity<Alliance> getAlliance(@PathVariable String allianceName) throws JsonProcessingException {
           return new ResponseEntity<>(allianceService.getAlliance(allianceName), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Alliance> createAlliance(@RequestBody Alliance alliance) {
        return new ResponseEntity<>(allianceService.createAlliance(alliance), HttpStatus.CREATED);
    }

    @PutMapping("/{allianceName}")
    public ResponseEntity<Alliance> updateAlliance(@PathVariable String allianceName, @RequestBody Alliance alliance) {
        return new ResponseEntity<>(allianceService.updateAlliance(allianceName, alliance), HttpStatus.OK);
    }

    @DeleteMapping("/{allianceName}")
    public ResponseEntity<HttpStatus> deleteAlliance(@PathVariable String allianceName) {
        allianceService.deleteAlliance(allianceName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{allianceName}/members")
    public ResponseEntity<List<LinkedHashMap<String, String>>> showAllianceMembers(@PathVariable String allianceName) {
        return new ResponseEntity<>(allianceService.getAllianceMembers(allianceName), HttpStatus.OK);
    }
}