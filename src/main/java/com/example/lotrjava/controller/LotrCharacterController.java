package com.example.lotrjava.controller;

import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.service.LotrCharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@AllArgsConstructor
@RequestMapping("/lotrcharacters")
@RestController
public class LotrCharacterController {

    LotrCharacterService lotrCharacterService;

    @GetMapping
    public ResponseEntity<List<LotrCharacter>> getLotrCharacters() {
        return new ResponseEntity<>(lotrCharacterService.getLotrCharacters(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinkedHashMap<String, String>> getLotrCharacter(@PathVariable Long id) {
        LotrCharacter foundCharacter = lotrCharacterService.getLotrCharacter(id);
        return new ResponseEntity<>(foundCharacter.nestedCharacterRepr(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String>> createLotrCharacter(@RequestBody HashMap<String, String> lotrCharacterRequest) {
        try {
            return new ResponseEntity<>(lotrCharacterService.createLotrCharacter(lotrCharacterRequest).nestedCharacterRepr(), HttpStatus.CREATED);
        } catch (NoSuchElementException exc) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "The requested Alliance does not exist.", exc);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LinkedHashMap<String, String>> updateLotrCharacter(@PathVariable Long id, @RequestBody HashMap<String, String> lotrCharacterRequest) {
        try {
            LotrCharacter updatedCharacter = lotrCharacterService.updateLotrCharacter(id, lotrCharacterRequest);
            return new ResponseEntity<>(updatedCharacter.nestedCharacterRepr(), HttpStatus.OK);
        } catch (NoSuchElementException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "requested character does not exist");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLotrCharacter(@PathVariable Long id) {
        try {
            lotrCharacterService.deleteLotrCharacter(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "requested character does not exist");
        }
    }
}