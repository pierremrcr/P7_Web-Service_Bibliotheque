package com.bibliotheque.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="livre")
public class LivreEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    private int id;

    @Column(name = "titre")
    @Size(min = 1, max = 50)
    private String titre;

    @Column(name = "auteur")
    @Size(min = 1, max = 50)
    private String auteur;

    @Column(name = "genre")
    @Size(min = 1, max = 25)
    private String genre;

    @Column(name = "date_publication")
    private Date date_publication;

    @Column(name="resume")
    @Size(min = 1, max = 2500)
    private String resume;

    @Column(name="url_photo")
    @Size(min = 1, max = 500)
    private String url_photo;

    @Column(name="bibliothequeid")
    private int bibliothequeid;

    @ManyToOne
    @JoinColumn(name = "bibliothequeid", insertable = false, updatable = false)
    private BibliothequeEntity bibliotheque;

    public LivreEntity() {
        this.titre = titre;
    }

    public LivreEntity(String titre, String auteur, String genre, Date date_publication, String resume, String url_photo, int bibliothequeid) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.date_publication = date_publication;
        this.resume = resume;
        this.url_photo = url_photo;
        this.bibliothequeid = bibliothequeid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public BibliothequeEntity getBibliotheque() {
        return bibliotheque;
   }

    public void setBibliotheque(BibliothequeEntity bibliotheque) {
        this.bibliotheque = bibliotheque;
  }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public int getBibliothequeid() {
        return bibliothequeid;
    }

    public void setBibliothequeid(int bibliothequeid) {
        this.bibliothequeid = bibliothequeid;
    }

    @Override
    public String toString() {
        return "LivreEntity{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", genre='" + genre + '\'' +
                ", date_publication='" + date_publication + '\'' +
                ", resume='" + resume + '\'' +
                ", bibliotheque=";
    }
}
