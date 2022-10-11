package com.example.lotrjava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "races")
public class Race implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "race_name", columnDefinition = "VARCHAR(64)", nullable = false)
    private String raceName;

    @NonNull
    @Column(name = "description", columnDefinition = "VARCHAR(800)", nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL)
    private List<LotrCharacter> lotrCharacterList;
}
