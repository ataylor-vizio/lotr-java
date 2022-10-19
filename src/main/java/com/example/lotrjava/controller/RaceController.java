package com.example.lotrjava.controller;

import com.example.lotrjava.entity.Race;

import com.example.lotrjava.service.RaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/races")
@RestController
public class RaceController {

    RaceService raceService;

    /**
     * Finds and returns a list of all LOTR races
     * @return list of LOTR races found
     */
    @Operation(summary = "Finds and returns all LOTR races.",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @GetMapping
    public ResponseEntity<List<Race>> getRaces() {
        return new ResponseEntity<>(raceService.getRaces(), HttpStatus.OK);
    }


    /** Finds and returns a single LOTR race by raceName (string)
     *
     * @param raceName path param of LOTR raceName
     * @return the LOTR race found or throws an error
     */
    @Operation(summary = "Finds and returns single LOTR race by raceName, throws error if LOTR race not found.",
            description = "raceName should be declared as a path variable.",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @GetMapping("/{raceName}")
    public ResponseEntity<Race> getRace(@PathVariable String raceName) {
        return new ResponseEntity<>(raceService.getRace(raceName), HttpStatus.OK);
    }


    /** Creates a new LOTR race
     *
     * @param race JSON body that corresponds to LOTR race schema
     * @return the LOTR race instance created
     */
    @Operation(summary = "Creates LOTR race",
            description = "JSON body should adhere to LOTR race model scheme",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @PostMapping
    @ResponseBody
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        return new ResponseEntity<>(raceService.createRace(race), HttpStatus.CREATED);
    }


    /** Edits an existing LOTR character
     *
     * @param raceName string
     * @param race JSON body that corresponds to LOTR race schema
     * @return the LOTR race instance edited
     */
    @Operation(summary = "Edits existing LOTR race if found, otherwise throws error",
            description = "JSON body should adhere to LOTR race model scheme",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @PutMapping("/{raceName}")
    public ResponseEntity<Race> updateRace(@PathVariable String raceName, @RequestBody Race race) {
        return new ResponseEntity<>(raceService.updateRace(raceName, race), HttpStatus.OK);
    }


    /** Deletes LOTR race if LOTR race with specified name is found
     *
     * @param raceName name of the LOTR race to be deleted from db
     * @return No Content
     */
    @Operation(summary = "Deletes a LOTR race if found, else throws an error",
            description = "No json body needed - path variable of LOTR raceName should be provided.",
            responses = {
                    @ApiResponse(responseCode = "204",
                            description = "No Content"),
            })
    @DeleteMapping("/{raceName}")
    public ResponseEntity<HttpStatus> deleteRace(@PathVariable String raceName) {
        raceService.deleteRace(raceName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    /** Retrieves all members of an alliance
//     *
//     * @param raceName name of LOTR race that returned members belong to
//     * @return raceMembers
//     */
//    @Operation(summary = "Find all characters associated with the LOTR race",
//            description = "Path variable of raceName should be provided.")
//    @Parameter(name = "allianceName")
//    @GetMapping("/{raceName}/members")
//    public ResponseEntity<List<LinkedHashMap<String, String>>> showRaceMembers(@PathVariable String raceName) {
//        return new ResponseEntity<>(raceService.getRaceMembers(raceName), HttpStatus.OK);
//    }
}
