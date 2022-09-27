package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.entity.LotrCharacter;
import com.example.lotrjava.repository.AllianceRepository;
import com.example.lotrjava.repository.LotrCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotrCharacterServiceImpl implements LotrCharacterService {

    @Autowired
    LotrCharacterRepository lotrCharacterRepository;
    AllianceRepository allianceRepository;

    @Override
    public LotrCharacter createLotrCharacter(LotrCharacter lotrCharacter) {
        return lotrCharacterRepository.save(lotrCharacter);
    }

    @Override
    public List<LotrCharacter> getLotrCharacters() {
       return (List<LotrCharacter>) lotrCharacterRepository.findAll();
    }

    @Override
    public Optional<LotrCharacter> getLotrCharacter(Long id) {
        return Optional.of(lotrCharacterRepository.findById(id).orElseThrow());
    }

    @Override
    public LotrCharacter updateLotrCharacter(Long id, LotrCharacter lotrCharacter) {
        Optional<LotrCharacter> existingCharacter = Optional.of(lotrCharacterRepository.findById(id).orElseThrow());
        LotrCharacter updatedLotrCharacter = existingCharacter.get();
        updatedLotrCharacter.setAlliance(lotrCharacter.getAlliance());
        updatedLotrCharacter.setName(lotrCharacter.getName());
        updatedLotrCharacter.setRace(lotrCharacter.getRace());
        lotrCharacterRepository.save(updatedLotrCharacter);
        return updatedLotrCharacter;
    }

    @Override
    public void deleteLotrCharacter(Long id) {
        Optional<LotrCharacter> existingCharacter = Optional.of(lotrCharacterRepository.findById(id).orElseThrow());
        lotrCharacterRepository.delete(existingCharacter.get());
    }
}
