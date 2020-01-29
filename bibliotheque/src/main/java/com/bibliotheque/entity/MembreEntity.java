package com.bibliotheque.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="membre")
public class MembreEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Size(min = 1, max = 10)
    private String motDePasse;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    @Size(min = 1, max = 50)
    private String ville;

    @OneToMany(mappedBy = "membreEntity", fetch = FetchType.EAGER)
    private List<EmpruntEntity> listeEmprunts;

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<EmpruntEntity> getListeEmprunts() {
        return listeEmprunts;
    }

    public void setListeEmprunts(List<EmpruntEntity> listeEmprunts) {
        this.listeEmprunts = listeEmprunts;
    }
}
