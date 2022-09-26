package com.example.lotrjava.repository;

import com.example.lotrjava.LotrCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LotrCharacterRepository extends CrudRepository<LotrCharacter, Long> {

}
