package com.example.lotrjava.service;

import com.example.lotrjava.LotrCharacter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LotrCharacterService {
    LotrCharacter createLotrCharacter(LotrCharacter lotrCharacter);
    List<LotrCharacter> getLotrCharacters();
    LotrCharacter getLotrCharacter(Long id);
}
