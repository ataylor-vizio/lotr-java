package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface LotrCharacterService {
    LotrCharacter createLotrCharacter(LotrCharacter lotrCharacter);
    List<LotrCharacter> getLotrCharacters();
    LotrCharacter getLotrCharacter(Long id);
    LotrCharacter updateLotrCharacter(Long id, HashMap<String, String> lotrCharacterRequest);
    void deleteLotrCharacter(Long id);
}
