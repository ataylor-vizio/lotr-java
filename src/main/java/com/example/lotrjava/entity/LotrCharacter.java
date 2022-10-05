package com.example.lotrjava.entity;

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
    @Column(unique = true)
    private String name;

    @NonNull
    @Column(name = "race", nullable = false)
    private String race;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alliance_id")
    private Alliance alliance;

    @Override
    public String toString() {
        return "LotrCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", alliance=" + alliance +
                '}';
    }
}

