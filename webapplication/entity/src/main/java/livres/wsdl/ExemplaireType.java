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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour exemplaireType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="exemplaireType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="disponibilite" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="livreid" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="livre" type="{http://www.bibliotheque.com/livres-ws}livreType"/&gt;
 *         &lt;element name="listeEmprunts" type="{http://www.bibliotheque.com/livres-ws}empruntType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exemplaireType", propOrder = {
    "id",
    "disponibilite",
    "livreid",
    "livre",
    "listeEmprunts"
})
public class ExemplaireType {

    protected int id;
    protected boolean disponibilite;
    protected int livreid;
    @XmlElement(required = true)
    protected LivreType livre;
    protected List<EmpruntType> listeEmprunts;

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
     * Obtient la valeur de la propriété disponibilite.
     * 
     */
    public boolean isDisponibilite() {
        return disponibilite;
    }

    /**
     * Définit la valeur de la propriété disponibilite.
     * 
     */
    public void setDisponibilite(boolean value) {
        this.disponibilite = value;
    }

    /**
     * Obtient la valeur de la propriété livreid.
     * 
     */
    public int getLivreid() {
        return livreid;
    }

    /**
     * Définit la valeur de la propriété livreid.
     * 
     */
    public void setLivreid(int value) {
        this.livreid = value;
    }

    /**
     * Obtient la valeur de la propriété livre.
     * 
     * @return
     *     possible object is
     *     {@link LivreType }
     *     
     */
    public LivreType getLivre() {
        return livre;
    }

    /**
     * Définit la valeur de la propriété livre.
     * 
     * @param value
     *     allowed object is
     *     {@link LivreType }
     *     
     */
    public void setLivre(LivreType value) {
        this.livre = value;
    }

    /**
     * Gets the value of the listeEmprunts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeEmprunts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeEmprunts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmpruntType }
     * 
     * 
     */
    public List<EmpruntType> getListeEmprunts() {
        if (listeEmprunts == null) {
            listeEmprunts = new ArrayList<EmpruntType>();
        }
        return this.listeEmprunts;
    }

}
