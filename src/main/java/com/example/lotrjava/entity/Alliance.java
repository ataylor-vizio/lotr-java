package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
//    @NonNull
//    @Column(name = "alliance", nullable = false, unique = true)
//
    @NonNull
    @Column(name = "alliance_name", nullable = false, unique = true)
    private String allianceName;

    @OneToMany(mappedBy = "alliance", cascade = CascadeType.ALL)
    private List<LotrCharacter> lotrCharacters;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "alliance_races",
            joinColumns = {@JoinColumn(name = "alliance_id")},
            inverseJoinColumns = {@JoinColumn(name = "race_id")})
    private List<Race> races;
}
