package com.bibliotheque.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="emprunt")
public class EmpruntEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    @Column(name = "prolongation")
    private boolean prolongation;

    @Column(name = "relance")
    private boolean relance;

    @Column(name = "termine")
    private boolean termine;

    @Column(name = "exemplaireid")
    private int exemplaireid;

    @Column(name = "membreid")
    private int membreid;

    @ManyToOne
    @JoinColumn(name = "membreid", insertable = false, updatable = false)
    private MembreEntity membreEntity;

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

    public boolean isRelance() {
        return relance;
    }

    public boolean isTermine() {
        return termine;
    }

    public void setTermine(boolean termine) {
        this.termine = termine;
    }

    public void setRelance(boolean relance) {
        this.relance = relance;
    }

    public int getExemplaireid() {
        return exemplaireid;
    }

    public void setExemplaireid(int exemplaireid) {
        this.exemplaireid = exemplaireid;
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

    public ExemplaireEntity getExemplaireEntity() {
        return exemplaireEntity;
    }

    public void setExemplaireEntity(ExemplaireEntity exemplaireEntity) {
        this.exemplaireEntity = exemplaireEntity;
    }

    @Override
    public String toString() {
        return "EmpruntEntity{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", prolongation= " + prolongation;
    }
}
