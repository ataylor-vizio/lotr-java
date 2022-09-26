package com.example.lotrjava.controller;

import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.service.LotrCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/lotrcharacters")
@RestController
public class LotrCharacterController {

    @Autowired
    LotrCharacterService lotrCharacterService;

    @GetMapping
    public ResponseEntity<List<LotrCharacter>> getLotrCharacters() {
        return new ResponseEntity<>(lotrCharacterService.getLotrCharacters(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LotrCharacter>> getLotrCharacter(@PathVariable Long id) {
        return new ResponseEntity<>(lotrCharacterService.getLotrCharacter(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<LotrCharacter> createLotrCharacter(@RequestBody LotrCharacter lotrCharacter) {
        return new ResponseEntity<>(lotrCharacterService.createLotrCharacter(lotrCharacter), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LotrCharacter> updateLotrCharacter(@PathVariable Long id, @RequestBody LotrCharacter lotrCharacter) {
        return new ResponseEntity<>(lotrCharacterService.updateLotrCharacter(id, lotrCharacter), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLotrCharacter(@PathVariable Long id) {
        lotrCharacterService.deleteLotrCharacter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}