package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

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

    @JsonIgnoreProperties
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "race", referencedColumnName = "race_name")
    private Race race;

}

