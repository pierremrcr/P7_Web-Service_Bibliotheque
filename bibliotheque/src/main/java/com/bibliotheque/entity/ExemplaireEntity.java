package com.bibliotheque.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="exemplaire")
public class ExemplaireEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="disponibilite")
    private boolean disponibilite;

    @Column(name="livreid")
    private int livreid;

    @ManyToOne
    @JoinColumn(name = "livreid", insertable = false, updatable = false)
    private LivreEntity livre;

    @OneToMany(mappedBy = "exemplaireEntity", fetch = FetchType.EAGER)
    private List<EmpruntEntity> listeEmprunts;


    public ExemplaireEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public LivreEntity getLivre() {
        return livre;
    }

    public void setLivre(LivreEntity livre) {
        this.livre = livre;
    }

    public List<EmpruntEntity> getListeEmprunts() {
        return listeEmprunts;
    }

    public void setListeEmprunts(List<EmpruntEntity> listeEmprunts) {
        this.listeEmprunts = listeEmprunts;
    }

    public int getLivreid() {
        return livreid;
    }

    public void setLivreid(int livreid) {
        this.livreid = livreid;
    }

    @Override
    public String toString() {
        return "ExemplaireEntity{" +
                "id=" + id +
                ", disponibilite=" + disponibilite +
                ", livreid=" + livreid +
                ", livre=" + livre +
                ", listeEmprunts=" + listeEmprunts +
                '}';
    }
}
