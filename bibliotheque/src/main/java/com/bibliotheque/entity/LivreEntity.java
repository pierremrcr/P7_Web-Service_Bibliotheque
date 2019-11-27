package com.bibliotheque.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="livre")
public class LivreEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Date datePublication;

    @Column(name="resume")
    @Size(min = 1, max = 2500)
    private String resume;

    @Column(name="url_photo")
    @Size(min = 1, max = 500)
    private String urlPhoto;

    @OneToMany(mappedBy = "livre", fetch = FetchType.EAGER)
    private List<ExemplaireEntity> listeExemplaires;

    public LivreEntity() {
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

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public List<ExemplaireEntity> getListeExemplaires() {
        return listeExemplaires;
    }

    public void setListeExemplaires(List<ExemplaireEntity> listeExemplaires) {
        this.listeExemplaires = listeExemplaires;
    }

    @Override
    public String toString() {
        return "LivreEntity{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", genre='" + genre + '\'' +
                ", datePublication=" + datePublication +
                ", resume='" + resume + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", listeExemplaires=" + listeExemplaires +
                '}';
    }
}
