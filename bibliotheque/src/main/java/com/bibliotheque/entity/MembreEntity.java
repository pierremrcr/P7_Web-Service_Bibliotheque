package com.bibliotheque.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="membre")
public class MembreEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom")
    @Size(min = 1, max = 50)
    private String nom;

    @Column(name = "prenom")
    @Size(min = 1, max = 50)
    private String prenom;
    @Column(name = "adresse_mail")
    @Size(min = 1, max = 50)
    private String adresse_mail;

    @Column(name = "mot_de_passe")
    @Size(min = 1, max = 50)
    private String mot_de_passe;

    @Column(name = "telephone")
    @Size(min = 1, max = 50)
    private String telephone;

    @Column(name = "num_carte_bibliotheque")
    @Size(min = 1, max = 50)
    private int num_carte_bibliotheque;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresseid")
    private AdresseEntity adresse;

    public MembreEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNum_carte_bibliotheque() {
        return num_carte_bibliotheque;
    }

    public void setNum_carte_bibliotheque(int num_carte_bibliotheque) {
        this.num_carte_bibliotheque = num_carte_bibliotheque;
    }

    /*

    public int getAdresseid() {
        return adresseid;
    }

    public void setAdresseid(int adresseid) {
        this.adresseid = adresseid;
    }

    */

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }
}
