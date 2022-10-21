package com.example.lotrjava.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashMap;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lotr_characters")
public class LotrCharacter implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "char_name", unique = true)
    private String char_name;

    @JsonBackReference
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "alliance_id", referencedColumnName = "id")
    private Alliance alliance;

    @JsonBackReference
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "race_id", referencedColumnName = "id")
    private Race race;
//
//    public LinkedHashMap<String, String> nestedCharacterRepr() {
//        LinkedHashMap<String, String> characterInfo = new LinkedHashMap<>();
//        characterInfo.put("id", id.toString());
//        characterInfo.put("name", char_name);
//        characterInfo.put("race", race.getRace_name());
//        characterInfo.put("alliance", alliance.getAlliance_name());
//        return characterInfo;
//    }
}

