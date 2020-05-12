//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.05.11 à 06:30:04 PM CEST 
//


package livres.wsdl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour livreType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="livreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="titre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="auteur" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="date_publication" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="resume" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="url_photo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="listeExemplaires" type="{http://www.bibliotheque.com/livres-ws}exemplaireType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "livreType", propOrder = {
    "id",
    "titre",
    "auteur",
    "genre",
    "datePublication",
    "resume",
    "urlPhoto",
    "listeExemplaires"
})
public class LivreType {

    protected int id;
    @XmlElement(required = true)
    protected String titre;
    @XmlElement(required = true)
    protected String auteur;
    @XmlElement(required = true)
    protected String genre;
    @XmlElement(name = "date_publication", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datePublication;
    @XmlElement(required = true)
    protected String resume;
    @XmlElement(name = "url_photo", required = true)
    protected String urlPhoto;
    protected List<ExemplaireType> listeExemplaires;

    /**
     * Obtient la valeur de la propriété id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété titre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit la valeur de la propriété titre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitre(String value) {
        this.titre = value;
    }

    /**
     * Obtient la valeur de la propriété auteur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Définit la valeur de la propriété auteur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuteur(String value) {
        this.auteur = value;
    }

    /**
     * Obtient la valeur de la propriété genre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Définit la valeur de la propriété genre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Obtient la valeur de la propriété datePublication.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatePublication() {
        return datePublication;
    }

    /**
     * Définit la valeur de la propriété datePublication.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatePublication(XMLGregorianCalendar value) {
        this.datePublication = value;
    }

    /**
     * Obtient la valeur de la propriété resume.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResume() {
        return resume;
    }

    /**
     * Définit la valeur de la propriété resume.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResume(String value) {
        this.resume = value;
    }

    /**
     * Obtient la valeur de la propriété urlPhoto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPhoto() {
        return urlPhoto;
    }

    /**
     * Définit la valeur de la propriété urlPhoto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPhoto(String value) {
        this.urlPhoto = value;
    }

    /**
     * Gets the value of the listeExemplaires property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeExemplaires property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeExemplaires().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExemplaireType }
     * 
     * 
     */
    public List<ExemplaireType> getListeExemplaires() {
        if (listeExemplaires == null) {
            listeExemplaires = new ArrayList<ExemplaireType>();
        }
        return this.listeExemplaires;
    }

}
