package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "races")
public class Race implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NonNull
    @Column(name = "race_name", columnDefinition = "VARCHAR(64)", nullable = false, unique = true)
    private String raceName;

    @NonNull
    @Column(name = "description", columnDefinition = "VARCHAR(800)", nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<LotrCharacter> lotrCharacterList;

    public LinkedHashMap<String, String> nestedRaceRepr() {
        LinkedHashMap<String, String> raceInfo = new LinkedHashMap<String, String>();
        raceInfo.put("id", id.toString());
        raceInfo.put("name", raceName);
        return raceInfo;
    }
}
