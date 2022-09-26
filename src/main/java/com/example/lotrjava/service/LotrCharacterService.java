package com.example.lotrjava.service;

import com.example.lotrjava.entity.LotrCharacter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LotrCharacterService {
    LotrCharacter createLotrCharacter(LotrCharacter lotrCharacter);
    List<LotrCharacter> getLotrCharacters();
    Optional<LotrCharacter> getLotrCharacter(Long id);
    LotrCharacter updateLotrCharacter(Long id, LotrCharacter lotrCharacter);
    void deleteLotrCharacter(Long id);
}
