package com.example.lotrjava.controller;

import com.example.lotrjava.LotrCharacter;
import com.example.lotrjava.service.LotrCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LotrCharacterController {

    @Autowired
    LotrCharacterService lotrCharacterService;

    @GetMapping("/lotrcharacters")
    public List getLotrCharacters() {
        return lotrCharacterService.getAllLotrCharacters();
    }

    @PostMapping("/lotrcharacters")
    @ResponseBody
    public LotrCharacter createLotrCharacter(@RequestBody LotrCharacter lotrCharacter) {
        return lotrCharacterService.create(lotrCharacter);
    }

    @GetMapping("/lotrcharacters/{id}")
    public Optional<LotrCharacter> getLotrCharacter(@PathVariable Long id) {
        return lotrCharacterService.findById(id);
    }

}