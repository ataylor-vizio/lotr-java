package com.example.lotrjava;

import javax.persistence.*;

@Entity
@Table(name = "lotr_characters")
public class LotrCharacter {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "race", nullable = false)
    private String race;

    @Column(name = "alliance", nullable = true)
    private String alliance;

    public LotrCharacter() {

    }

    public LotrCharacter(Long id, String name, String race, String alliance) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.alliance = alliance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

}

