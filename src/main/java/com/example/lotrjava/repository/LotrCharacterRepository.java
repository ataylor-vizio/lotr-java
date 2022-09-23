package com.example.lotrjava.repository;

import com.example.lotrjava.LotrCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotrCharacterRepository extends JpaRepository<LotrCharacter, LotrCharacter> {

    List<LotrCharacter> findAll();
    Optional<LotrCharacter> findById(Long id);
    List<LotrCharacter> findLotrCharactersByAlliance(String alliance);
    List<LotrCharacter> findLotrCharactersByNameIsLike(String name);
}
