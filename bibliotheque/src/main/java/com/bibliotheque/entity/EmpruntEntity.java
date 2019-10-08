package com.bibliotheque.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="emprunt")
public class EmpruntEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    @Column(name = "prolongation")
    private boolean prolongation;

    @Column(name = "membreid")
    private int membreid;

    @ManyToOne
    @JoinColumn(name = "membreid", insertable = false, updatable = false)
    private MembreEntity membreEntity;

    @Column(name = "exemplaireid")
    private int exemplaireid;

    @ManyToOne
    @JoinColumn(name = "exemplaireid", insertable = false, updatable = false)
    private ExemplaireEntity exemplaireEntity;

    public EmpruntEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public boolean isProlongation() {
        return prolongation;
    }

    public void setProlongation(boolean prolongation) {
        this.prolongation = prolongation;
    }

    public int getMembreid() {
        return membreid;
    }

    public void setMembreid(int membreid) {
        this.membreid = membreid;
    }

    public MembreEntity getMembreEntity() {
        return membreEntity;
    }

    public void setMembreEntity(MembreEntity membreEntity) {
        this.membreEntity = membreEntity;
    }

    public int getExemplaireid() {
        return exemplaireid;
    }

    public void setExemplaireid(int exemplaireid) {
        this.exemplaireid = exemplaireid;
    }

    public ExemplaireEntity getExemplaireEntity() {
        return exemplaireEntity;
    }

    public void setExemplaireEntity(ExemplaireEntity exemplaireEntity) {
        this.exemplaireEntity = exemplaireEntity;
    }
}
