package com.example.lotrjava.repository;

import com.example.lotrjava.entity.LotrCharacter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotrCharacterRepository extends CrudRepository<LotrCharacter, Long> {

}
