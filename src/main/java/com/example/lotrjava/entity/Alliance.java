package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alliances")
public class Alliance implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "alliance_name", nullable = false, unique = true)
    private String allianceName;

    @JsonIgnore
    @OneToMany(mappedBy = "alliance", cascade = CascadeType.ALL)
    private List<LotrCharacter> lotrCharacters;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "alliance_races",
            joinColumns = {@JoinColumn(name = "alliance_id")},
            inverseJoinColumns = {@JoinColumn(name = "race_id")})
    private List<Race> races;

    public LinkedHashMap<String, String> nestedAllianceRepr() {
        LinkedHashMap<String, String> allianceInfo = new LinkedHashMap<String, String>();
        allianceInfo.put("id", id.toString());
        allianceInfo.put("name", allianceName);
        return allianceInfo;
    }
}
