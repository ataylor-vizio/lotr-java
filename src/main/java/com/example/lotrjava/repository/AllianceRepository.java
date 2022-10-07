package com.example.lotrjava.repository;

import com.example.lotrjava.entity.Alliance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllianceRepository extends CrudRepository<Alliance, Long> {
    Optional<Alliance> findByAlliancenameIs(String allianceName);
}
