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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="membreType" type="{http://www.bibliotheque.com/livres-ws}membreType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "membreType"
})
@XmlRootElement(name = "getMembreByIdResponse")
public class GetMembreByIdResponse {

    @XmlElement(required = true)
    protected MembreType membreType;

    /**
     * Obtient la valeur de la propriété membreType.
     * 
     * @return
     *     possible object is
     *     {@link MembreType }
     *     
     */
    public MembreType getMembreType() {
        return membreType;
    }

    /**
     * Définit la valeur de la propriété membreType.
     * 
     * @param value
     *     allowed object is
     *     {@link MembreType }
     *     
     */
    public void setMembreType(MembreType value) {
        this.membreType = value;
    }

}
