package com.example.lotrjava.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "alliances")
public class Alliance {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Column(name = "alliance", nullable = false)
    private String alliance;

    @OneToMany(mappedBy = "alliance")
    private List<LotrCharacter> lotrCharacters;
}
