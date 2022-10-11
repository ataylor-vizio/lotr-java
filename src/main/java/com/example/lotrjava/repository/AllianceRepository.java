package com.example.lotrjava.repository;

import com.example.lotrjava.entity.Alliance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllianceRepository extends CrudRepository<Alliance, Long> {

    Optional<Alliance> findByAllianceName (String allianceName);
}
