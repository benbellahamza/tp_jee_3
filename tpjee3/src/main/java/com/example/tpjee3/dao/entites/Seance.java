package com.example.tpjee3.dao.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seance {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private Date date;
    private Date h_debut;
    private Date h_fin;
    @ManyToMany(mappedBy = "seance")
    private Collection<Etudiant> etudiants ;
    @ManyToOne
    private Cours cours;

}
