//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.11 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.05.01 à 11:00:43 AM CEST 
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
 *         &lt;element name="compteType" type="{http://www.bibliotheque.com/livres-ws}membreType"/&gt;
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
    "compteType"
})
@XmlRootElement(name = "getCompteAfterLoginSuccessResponse")
public class GetCompteAfterLoginSuccessResponse {

    @XmlElement(required = true)
    protected MembreType compteType;

    /**
     * Obtient la valeur de la propriété compteType.
     * 
     * @return
     *     possible object is
     *     {@link MembreType }
     *     
     */
    public MembreType getCompteType() {
        return compteType;
    }

    /**
     * Définit la valeur de la propriété compteType.
     * 
     * @param value
     *     allowed object is
     *     {@link MembreType }
     *     
     */
    public void setCompteType(MembreType value) {
        this.compteType = value;
    }

}
