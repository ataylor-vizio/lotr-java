package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public interface LotrCharacterService {
    LotrCharacter createLotrCharacter(HashMap<String, String> lotrCharacter);
    List<LotrCharacter> getLotrCharacters();
    LotrCharacter getLotrCharacter(Long id);
    LotrCharacter updateLotrCharacter(Long id, HashMap<String, String> lotrCharacterRequest);
    void deleteLotrCharacter(Long id);
}
