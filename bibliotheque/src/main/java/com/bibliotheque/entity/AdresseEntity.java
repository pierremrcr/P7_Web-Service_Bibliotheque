package com.bibliotheque.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name="adresse")
public class AdresseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true, name="numero")
    private BigInteger numero;

    @Column(name = "rue")
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

    public BigInteger getNumero() {
        return numero;
    }

    public void setNumero(BigInteger numero) {
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

    public MembreEntity getMembre() {
        return membre;
    }

    public void setMembre(MembreEntity membre) {
        this.membre = membre;
    }
}
