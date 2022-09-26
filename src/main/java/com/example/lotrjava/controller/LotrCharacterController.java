package com.example.lotrjava.controller;

import com.example.lotrjava.LotrCharacter;
import com.example.lotrjava.service.LotrCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<LotrCharacter> getLotrCharacter(@PathVariable Long id) {
        return new ResponseEntity<>(lotrCharacterService.getLotrCharacter(id), HttpStatus.OK);
    }

    @PostMapping("/lotrcharacters")
    @ResponseBody
    public ResponseEntity<LotrCharacter> createLotrCharacter(@RequestBody LotrCharacter lotrCharacter) {
        return new ResponseEntity<>(lotrCharacterService.createLotrCharacter(lotrCharacter), HttpStatus.CREATED);
    }
//
//    @GetMapping("/lotrcharacters/{id}")
//    public Optional<LotrCharacter> getLotrCharacter(@PathVariable Long id) {
//        return lotrCharacterService.findById(id);
//    }

}