package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashMap;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lotr_characters")
public class LotrCharacter {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "char_name", unique = true)
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alliance", referencedColumnName = "alliance_name")
    private Alliance alliance;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "race", referencedColumnName = "race_name")
    private Race race;

    public LinkedHashMap<String, String> nestedCharacterRepr() {
        LinkedHashMap<String, String> characterInfo = new LinkedHashMap<>();
        characterInfo.put("id", id.toString());
        characterInfo.put("name", name);
        characterInfo.put("race", race.getRaceName());
        characterInfo.put("alliance", alliance.getAllianceName());
        return characterInfo;
    }
}

