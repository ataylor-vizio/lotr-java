package com.example.lotrjava.service;

import com.example.lotrjava.LotrCharacter;
import com.example.lotrjava.repository.LotrCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotrCharacterService {

    @Autowired
    LotrCharacterRepository lotrCharacterRepository;

    public List<LotrCharacter> getAllLotrCharacters() {
        return lotrCharacterRepository.findAll();
    }

    public LotrCharacter create(LotrCharacter lotrCharacter) {
        System.out.println(lotrCharacter.toString());
//        LotrCharacter created = new LotrCharacter(lotrCharacter);
//        lotrCharacterRepository.save(created);
        return lotrCharacter;
    }

    public List<LotrCharacter> findByAlliance(String alliance) {
        return lotrCharacterRepository.findLotrCharactersByAlliance(alliance);
    }

    public List<LotrCharacter> findByName(String name) {
        return lotrCharacterRepository.findLotrCharactersByNameIsLike(name);
    }

    public Optional<LotrCharacter> findById(Long id) {
        return lotrCharacterRepository.findById(id);
    }
}
