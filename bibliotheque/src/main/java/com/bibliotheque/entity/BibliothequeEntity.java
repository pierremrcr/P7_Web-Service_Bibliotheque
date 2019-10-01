package com.bibliotheque.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="bibliotheque")
public class BibliothequeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom")
    @Size(min = 1, max = 50)
    private String nom;

    @Column(name = "telephone")
    @Size(min = 1, max = 10)
    private String telephone;

    @Column(name="adresseid")
    private int adresseid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresseid", insertable = false, updatable = false)
    private AdresseEntity adresse;

    @OneToMany(mappedBy = "bibliotheque")
    private List<LivreEntity> listeLivres;

    @OneToMany(mappedBy = "bibliotheque")
    private List<MembreEntity> listeMembres;


    public BibliothequeEntity() {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<LivreEntity> getListeLivres() {
        return listeLivres;
    }

    public void setListeLivres(List<LivreEntity> listeLivres) {
       this.listeLivres = listeLivres;
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

    public List<MembreEntity> getListeMembres() {
        return listeMembres;
    }

    public void setListeMembres(List<MembreEntity> listeMembres) {
        this.listeMembres = listeMembres;
    }

    @Override
    public String toString() {
        return "Bibliotheque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }


}
