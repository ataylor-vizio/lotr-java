package com.example.lotrjava.controller;

import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.service.LotrCharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    /**
     * Finds and returns a list of all LOTR Characters
     * @return list of characters found
     */
    @Operation(summary = "Finds and returns all characters.",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @GetMapping
    public ResponseEntity<List<LotrCharacter>> getLotrCharacters() {
        return new ResponseEntity<>(lotrCharacterService.getLotrCharacters(), HttpStatus.OK);
    }


    /** Finds and returns a single LOTR Character by character ID
     *
     * @param id ID of the character to be found
     * @return the character found or throws an error
     */
    @Operation(summary = "Finds and returns single character by characterId, throws error if character not found.",
            description = "character ID should be declared as a path variable.",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @GetMapping("/{id}")
    public ResponseEntity<LotrCharacter> getLotrCharacter(@PathVariable Long id) {
        LotrCharacter foundCharacter = lotrCharacterService.getLotrCharacter(id);
        return new ResponseEntity<>(foundCharacter, HttpStatus.OK);
    }


    /** Creates a new LOTR character
     *
     * @param json Map<String, String> JSON body that corresponds to lotr character schema
     * @return the character instance created
     */
    @Operation(summary = "Creates lotr character",
            description = "JSON body should adhere to lotr character model scheme",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @PostMapping
    @ResponseBody
    public ResponseEntity<LotrCharacter> createLotrCharacter(@RequestBody Map<String, String> json) {
        String char_name = json.get("char_name");
        String alliance_id = json.get("alliance_id");
        String race_id = json.get("race_id");
        try {
            return new ResponseEntity<>(lotrCharacterService.createLotrCharacter(char_name, alliance_id, race_id), HttpStatus.CREATED);
        } catch (NoSuchElementException exc) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, exc.getMessage());
        }
    }


    /** Edits an existing LOTR character
     *
     * @param id Long
     * @param json RequestBody JSON body that corresponds to lotr character schema
     * @return the character instance edited
     */
    @Operation(summary = "Edits existing lotr character if found, otherwise throws error",
            description = "JSON body should adhere to lotr character model scheme",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @PutMapping("/{id}")
    public ResponseEntity<LotrCharacter> updateLotrCharacter(@PathVariable Long id, @RequestBody Map<String, String> json) {
        System.out.println(id);
        String char_name = json.get("char_name");
        String alliance_id = json.get("alliance_id");
        String race_id = json.get("race_id");
        try {
           return new ResponseEntity<>(lotrCharacterService.updateLotrCharacter(id, char_name, alliance_id, race_id), HttpStatus.OK);
        } catch (NoSuchElementException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "requested character does not exist");
        }
    }

    /** Deletes character if character with specified ID is found
     *
     * @param id type Long, ID of the character that is to be deleted
     * @return No Content
     */
    @Operation(summary = "Deletes a character if found, else throws an error",
            description = "No json body needed - path variable of character ID should be provided.",
            responses = {
                    @ApiResponse(responseCode = "204",
                            description = "No Content"),
            })
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