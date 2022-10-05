package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alliances")
public class Alliance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "alliance", nullable = false, unique = true)
    private String alliance;

    @JsonIgnore
    @OneToMany(mappedBy = "alliance", cascade = CascadeType.ALL)
    private List<LotrCharacter> lotrCharacters;
}
