package com.example.lotrjava.controller;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.service.AllianceService;
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
@RequestMapping("/alliances")
@RestController
public class AllianceController {

    AllianceService allianceService;

    /**
     * Finds and returns a list of all alliances
     * @return list of alliances found
     */
    @Operation(summary = "Finds and returns all alliances.",
        responses = {
            @ApiResponse(content = @Content(mediaType= "application/json")),
    })
    @GetMapping
    public ResponseEntity<List<Alliance>> getAlliances() {
        return new ResponseEntity<>(allianceService.getAlliances(), HttpStatus.OK);
    }

    /** Finds and returns a single alliance by allianceName
     *
     * @param allianceName name of the alliance to be found
     * @return the alliance model instance found
     */
    @Operation(summary = "Finds and returns single alliance by allianceName, throws error if alliance not found.",
            description = "allianceName should be declared as a path variable.",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @GetMapping("/{allianceName}")
    public ResponseEntity<Alliance> getAlliance(@PathVariable String allianceName) {
           return new ResponseEntity<>(allianceService.getAlliance(allianceName), HttpStatus.OK);
    }

    /** Creates a new alliance with given alliance name
     *
     * @param alliance Name of the alliance to be created - ex: "allianceName": "good".
     * @return the alliance model instance created
     */
    @Operation(summary = "Creates new alliance",
            description = "JSON should be submitted with only the allianceName field and corresponding value",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @Parameter(name = "allianceName")
    @PostMapping
    @ResponseBody
    public ResponseEntity<Alliance> createAlliance(@RequestBody Alliance alliance) {
        return new ResponseEntity<>(allianceService.createAlliance(alliance), HttpStatus.CREATED);
    }

    /** Edits existing alliance if alliance is found
     *
     * @param allianceName  path variable string of allianceName
     * @param alliance full alliance object in json object to be edited
     * @return the alliance model instance edited
     */
    @Operation(summary = "Edits existing alliance",
            description = "JSON should be submitted with only the allianceName field and corresponding value",
            responses = {
                    @ApiResponse(content = @Content(mediaType= "application/json")),
            })
    @Parameter(name = "allianceName")
    @Parameter(name = "alliance")
    @PutMapping("/{allianceName}")
    public ResponseEntity<Alliance> updateAlliance(@PathVariable String allianceName, @RequestBody Alliance alliance) {
        return new ResponseEntity<>(allianceService.updateAlliance(allianceName, alliance), HttpStatus.OK);
    }

    /** Deletes alliance if alliance is found
     *
     * @param allianceName name of alliance to be deleted
     * @return No Content
     */
    @Operation(summary = "Deletes an alliance if found, else throws an error",
            description = "No json body needed - path variable of allianceName should be provided.",
            responses = {
                    @ApiResponse(responseCode = "204",
                    description = "No Content"),
            })
    @Parameter(name = "allianceName")
    @DeleteMapping("/{allianceName}")
    public ResponseEntity<HttpStatus> deleteAlliance(@PathVariable String allianceName) {
        allianceService.deleteAlliance(allianceName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    /** Retrieves all members of an alliance
//     *
//     * @param allianceName name of alliance to which returned members belong to
//     * @return allianceMembers
//     */
//    @Operation(summary = "Find all characters associated with the alliance",
//            description = "Path variable of allianceName should be provided.")
//    @Parameter(name = "allianceName")
//    @GetMapping("/{allianceName}/members")
//    public ResponseEntity<List<LinkedHashMap<String, String>>> showAllianceMembers(@PathVariable String allianceName) {
//        return new ResponseEntity<>(allianceService.getAllianceMembers(allianceName), HttpStatus.OK);
//    }
}