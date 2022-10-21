package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public interface LotrCharacterService {
    LotrCharacter createLotrCharacter(String char_name, String alliance_id, String race_id);
    List<LotrCharacter> getLotrCharacters();
    LotrCharacter getLotrCharacter(Long id);
    LotrCharacter updateLotrCharacter(Long id, LotrCharacter lotrCharacter);
    void deleteLotrCharacter(Long id);
}
