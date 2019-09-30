package com.bibliotheque.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="emprunt")
public class EmpruntEntity implements Serializable {

    @GeneratedValue
    @Id
    private int id;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    @Column(name = "prolongation")
    private boolean prolongation;

    @Column(name = "membreid")
    private int membreid;

    @Column(name = "livreid")
    private int livreid;

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

    public int getLivreid() {
        return livreid;
    }

    public void setLivreid(int livreid) {
        this.livreid = livreid;
    }

}
