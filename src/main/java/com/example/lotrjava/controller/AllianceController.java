package com.example.lotrjava.controller;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.service.AllianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/alliances")
@RestController
public class AllianceController {

    @Autowired
    AllianceService allianceService;

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

//    @PutMapping("/{id}")
//    public ResponseEntity<LotrCharacter> updateLotrCharacter(@PathVariable Long id, @RequestBody LotrCharacter lotrCharacter) {
//        return new ResponseEntity<>(lotrCharacterService.updateLotrCharacter(id, lotrCharacter), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deleteLotrCharacter(@PathVariable Long id) {
//        lotrCharacterService.deleteLotrCharacter(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}