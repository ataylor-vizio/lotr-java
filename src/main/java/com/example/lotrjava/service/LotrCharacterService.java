package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LotrCharacterService {
    LotrCharacter createLotrCharacter(String char_name, String alliance_id, String race_id);
    List<LotrCharacter> getLotrCharacters();
    LotrCharacter getLotrCharacter(Long id);
    LotrCharacter updateLotrCharacter(Long id, String char_name, String alliance_id, String race_id);
    void deleteLotrCharacter(Long id);
}
