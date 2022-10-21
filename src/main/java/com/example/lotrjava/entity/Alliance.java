package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NonNull
    @Column(name = "alliance_name", nullable = false, unique = true)
    private String alliance_name;

    @JsonManagedReference(value = "alliance_characters")
    @OneToMany(mappedBy = "alliance", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LotrCharacter> lotrCharacters;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "alliance_races",
            joinColumns = {@JoinColumn(name = "alliance_id")},
            inverseJoinColumns = {@JoinColumn(name = "race_id")})
    private List<Race> races;

//    public LinkedHashMap<String, String> nestedAllianceRepr() {
//        LinkedHashMap<String, String> allianceInfo = new LinkedHashMap<String, String>();
//        allianceInfo.put("id", id.toString());
//        allianceInfo.put("alliance_name", alliance_name);
//        return allianceInfo;
//    }
}
