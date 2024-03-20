package com.example.tpjee3.dao.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cours")

public class Cours {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String titre;
    private String description;
    @OneToOne
    private Professeur professeur;
    @OneToMany(mappedBy = "cours", fetch = FetchType.LAZY)
    private Collection<Seance> seance;


}
