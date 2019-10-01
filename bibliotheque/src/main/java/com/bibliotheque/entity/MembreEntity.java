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
    private String adresseMail;

    @Column(name = "mot_de_passe")
    @Size(min = 1, max = 50)
    private String motDePasse;

    @Column(name = "telephone")
    @Size(min = 1, max = 50)
    private String telephone;

    @Column(name = "num_carte_bibliotheque")
    @Size(min = 1, max = 50)
    private String numCarteBibliotheque;

    @Column(name="adresseid")
    private int adresseid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresseid", insertable = false, updatable = false)
    private AdresseEntity adresse;

    @Column(name="bibliothequeid")
    private int bibliothequeid;

    @ManyToOne
    @JoinColumn(name = "bibliothequeid", insertable = false, updatable = false)
    private BibliothequeEntity bibliotheque;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAdresseid() {
        return adresseid;
    }

    public void setAdresseid(int adresseid) {
        this.adresseid = adresseid;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNumCarteBibliotheque() {
        return numCarteBibliotheque;
    }

    public void setNumCarteBibliotheque(String numCarteBibliotheque) {
        this.numCarteBibliotheque = numCarteBibliotheque;
    }

    public int getBibliothequeid() {
        return bibliothequeid;
    }

    public void setBibliothequeid(int bibliothequeid) {
        this.bibliothequeid = bibliothequeid;
    }

    public BibliothequeEntity getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(BibliothequeEntity bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
}
