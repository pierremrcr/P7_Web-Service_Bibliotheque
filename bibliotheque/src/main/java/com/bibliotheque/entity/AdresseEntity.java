package com.bibliotheque.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="adresse")
public class AdresseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "numero")
    @Size(min = 1, max = 50)
    private int numero;
    @Column(name = "rue")
    @Size(min = 1, max = 50)
    private String rue;
    @Column(name = "code_postal")
    @Size(min = 1, max = 50)
    private String codePostal;
    @Column(name = "ville")
    @Size(min = 1, max = 50)
    private String ville;
    @Column(name = "pays")
    @Size(min = 1, max = 50)
    private String pays;

    @OneToOne(mappedBy ="adresse")
    private BibliothequeEntity bibliotheque;

    @OneToOne(mappedBy = "adresse")
    private MembreEntity membre;

    public AdresseEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public BibliothequeEntity getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(BibliothequeEntity bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public MembreEntity getMembre() {
        return membre;
    }

    public void setMembre(MembreEntity membre) {
        this.membre = membre;
    }
}
