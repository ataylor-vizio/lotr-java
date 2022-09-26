package com.example.lotrjava.service;

import com.example.lotrjava.LotrCharacter;
import com.example.lotrjava.repository.LotrCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LotrCharacterServiceImpl implements LotrCharacterService {

    @Autowired
    LotrCharacterRepository lotrCharacterRepository;

    @Override
    public LotrCharacter createLotrCharacter(LotrCharacter lotrCharacter) {
        return lotrCharacterRepository.save(lotrCharacter);
    }

    @Override
    public List<LotrCharacter> getLotrCharacters() {
       return (List<LotrCharacter>) lotrCharacterRepository.findAll();
    }

    public LotrCharacter getLotrCharacter(Long id) {
        Optional<LotrCharacter> lotrCharacter = lotrCharacterRepository.findById(id);
        if (lotrCharacter.isPresent()) return lotrCharacter.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find character.");
    }
//
//    public LotrCharacter create(LotrCharacter lotrCharacter) {
//        return lotrCharacterRepository.save(lotrCharacter);
//    }
//
//    public List<LotrCharacter> findByAlliance(String alliance) {
//        return lotrCharacterRepository.findLotrCharactersByAlliance(alliance);
//    }
//
//    public List<LotrCharacter> findByName(String name) {
//        return lotrCharacterRepository.findLotrCharactersByNameIsLike(name);
//    }
//
//    public Optional<LotrCharacter> findById(Long id) {
//        return lotrCharacterRepository.findById(id);
//    }
}
