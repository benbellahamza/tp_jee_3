package com.example.tpjee3;

import com.example.tpjee3.dao.entites.Etudiant;
import com.example.tpjee3.dao.entites.Professeur;
import com.example.tpjee3.dao.entites.Seance;
import com.example.tpjee3.dao.repositories.CoursRepository;
import com.example.tpjee3.dao.repositories.EtudiantRepository;
import com.example.tpjee3.dao.repositories.ProfesseurRepository;
import com.example.tpjee3.dao.repositories.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tpjee3Application implements CommandLineRunner {

    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired

    private SeanceRepository seancerepository;
    @Autowired
    private ProfesseurRepository professeurRepository;
    private com.example.tpjee3.dao.entites.Seance Seance;
    private com.example.tpjee3.dao.entites.Cours Cours;
    private com.example.tpjee3.dao.entites.Cours cours;


    public static void main(String[] args) {
        SpringApplication.run(Tpjee3Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        //Create Professeur
    Professeur professeur=new Professeur();
    professeur.setId(1);
    professeur.setNom("hamza");
    professeur.setD_affectation(new Date());
        Professeur professeur1=new Professeur();
        professeur.setId(2);
        professeur.setNom("ayoub");
        professeur.setD_affectation(new Date());
        professeurRepository.save(professeur);
        professeurRepository.save(professeur1);
        //Read Professeur
        List<Professeur> professeurList = professeurRepository.findAll();
        professeurList.forEach(professeurFromList -> {

            System.out.println(professeurFromList.toString());

        });
        //Update professeur
        Professeur professeurUpdatedById = professeurRepository.findById(1).get();
        System.out.println(professeurUpdatedById);
        professeurUpdatedById.setNom("Yes updated");
        professeurRepository.save(professeurUpdatedById);
        professeurUpdatedById = professeurRepository.findById(1).get();
        System.out.println(professeurUpdatedById);
        System.out.println(professeurRepository.findById(1).get());
        professeurRepository.delete(professeur1);
        try {
            System.out.println(professeurRepository.findById(1).get());
        } catch (Exception exception) {
            System.out.println("The teacher has been deleted");
        }
        // Création d'une séance
        Seance seance = new Seance();
        seance.setDate(new Date());
        seance.setH_debut(new Date());
        seance.setH_fin(new Date());
        seance.setCours(Cours);
        seancerepository.save(seance);
        //Affichage Séance
        System.out.println("Voici la seance");
        System.out.println(seance);
        //Cours-->Professeur
        professeur.setCours(cours);
        professeurRepository.save(professeur);
        //Affichage Professeur
        System.out.println("******************Voici le professeur******************");
        System.out.println(professeur);
        // Création d'un étudiant
        Etudiant etudiant =new Etudiant();
        etudiant.setMatricule("V4285");
        etudiant.setNom("Etudiant");
        etudiantRepository.save(etudiant);
        //Affichage d'un étudiant
        System.out.println("Voici l'etudiant");
        System.out.println(etudiant);
        //Etudiant ---> Séance
        Seance.getEtudiants().add(etudiant);
        seancerepository.save(Seance);
        //Affichage Séance
        System.out.println("Voici la seance");
        System.out.println(Seance);

    }


}
