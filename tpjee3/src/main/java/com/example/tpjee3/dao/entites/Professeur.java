package com.example.tpjee3.dao.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Professeur")

public class Professeur {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nom;
    private Date d_affectation;
    @OneToOne(mappedBy = "professeur")
    private Cours cours;
}
