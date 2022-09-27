package com.example.lotrjava.service;

import com.example.lotrjava.entity.Alliance;
import com.example.lotrjava.repository.AllianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllianceServiceImpl implements AllianceService {

    @Autowired
    AllianceRepository allianceRepository;

    @Override
    public Alliance createAlliance(Alliance alliance) {
        return allianceRepository.save(alliance);
    }

    @Override
    public List<Alliance> getAlliances() {
        return (List<Alliance>) allianceRepository.findAll();
    }

    @Override
    public Optional<Alliance> getAlliance(Long id) {
        return Optional.of(allianceRepository.findById(id).orElseThrow());
    }
//
//    @Override
//    public Alliance updateAlliance(Long id, Alliance alliance) {
//        return null;
//    }
//
//    @Override
//    public void deleteAlliance(Long id) {

//}
}
