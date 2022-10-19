package com.example.lotrjava.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    private String name;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "alliance", referencedColumnName = "alliance_name")
    private Alliance alliance;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "race", referencedColumnName = "race_name")
    private Race race;
//
//    public LinkedHashMap<String, String> nestedCharacterRepr() {
//        LinkedHashMap<String, String> characterInfo = new LinkedHashMap<>();
//        characterInfo.put("id", id.toString());
//        characterInfo.put("name", name);
//        characterInfo.put("race", race.getRaceName());
//        characterInfo.put("alliance", alliance.getAllianceName());
//        return characterInfo;
//    }
}

