//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.05.11 à 06:30:04 PM CEST 
//


package livres.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour empruntType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="empruntType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="date_debut" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="date_fin" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="prolongation" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="relance" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="termine" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="membreid" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="membreEntity" type="{http://www.bibliotheque.com/livres-ws}membreType"/&gt;
 *         &lt;element name="exemplaireid" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="exemplaireEntity" type="{http://www.bibliotheque.com/livres-ws}exemplaireType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "empruntType", propOrder = {
    "id",
    "dateDebut",
    "dateFin",
    "prolongation",
    "relance",
    "termine",
    "membreid",
    "membreEntity",
    "exemplaireid",
    "exemplaireEntity"
})
public class EmpruntType {

    protected int id;
    @XmlElement(name = "date_debut", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateDebut;
    @XmlElement(name = "date_fin", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateFin;
    protected boolean prolongation;
    protected boolean relance;
    protected boolean termine;
    protected int membreid;
    @XmlElement(required = true)
    protected MembreType membreEntity;
    protected int exemplaireid;
    @XmlElement(required = true)
    protected ExemplaireType exemplaireEntity;

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
     * Obtient la valeur de la propriété dateDebut.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la valeur de la propriété dateDebut.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDebut(XMLGregorianCalendar value) {
        this.dateDebut = value;
    }

    /**
     * Obtient la valeur de la propriété dateFin.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateFin() {
        return dateFin;
    }

    /**
     * Définit la valeur de la propriété dateFin.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateFin(XMLGregorianCalendar value) {
        this.dateFin = value;
    }

    /**
     * Obtient la valeur de la propriété prolongation.
     * 
     */
    public boolean isProlongation() {
        return prolongation;
    }

    /**
     * Définit la valeur de la propriété prolongation.
     * 
     */
    public void setProlongation(boolean value) {
        this.prolongation = value;
    }

    /**
     * Obtient la valeur de la propriété relance.
     * 
     */
    public boolean isRelance() {
        return relance;
    }

    /**
     * Définit la valeur de la propriété relance.
     * 
     */
    public void setRelance(boolean value) {
        this.relance = value;
    }

    /**
     * Obtient la valeur de la propriété termine.
     * 
     */
    public boolean isTermine() {
        return termine;
    }

    /**
     * Définit la valeur de la propriété termine.
     * 
     */
    public void setTermine(boolean value) {
        this.termine = value;
    }

    /**
     * Obtient la valeur de la propriété membreid.
     * 
     */
    public int getMembreid() {
        return membreid;
    }

    /**
     * Définit la valeur de la propriété membreid.
     * 
     */
    public void setMembreid(int value) {
        this.membreid = value;
    }

    /**
     * Obtient la valeur de la propriété membreEntity.
     * 
     * @return
     *     possible object is
     *     {@link MembreType }
     *     
     */
    public MembreType getMembreEntity() {
        return membreEntity;
    }

    /**
     * Définit la valeur de la propriété membreEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link MembreType }
     *     
     */
    public void setMembreEntity(MembreType value) {
        this.membreEntity = value;
    }

    /**
     * Obtient la valeur de la propriété exemplaireid.
     * 
     */
    public int getExemplaireid() {
        return exemplaireid;
    }

    /**
     * Définit la valeur de la propriété exemplaireid.
     * 
     */
    public void setExemplaireid(int value) {
        this.exemplaireid = value;
    }

    /**
     * Obtient la valeur de la propriété exemplaireEntity.
     * 
     * @return
     *     possible object is
     *     {@link ExemplaireType }
     *     
     */
    public ExemplaireType getExemplaireEntity() {
        return exemplaireEntity;
    }

    /**
     * Définit la valeur de la propriété exemplaireEntity.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemplaireType }
     *     
     */
    public void setExemplaireEntity(ExemplaireType value) {
        this.exemplaireEntity = value;
    }

}
