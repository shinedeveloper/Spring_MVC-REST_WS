
package net.sevecek.videoboss.webservice.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <p>Java class for filmIdsListType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="filmIdsListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="film" type="{urn:videoboss.sevecek.net}filmLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filmIdsListType", propOrder = {
    "films"
})
@XmlRootElement(name = "filmIds")
public class JaxbFilmIdsList {

    @XmlElement(name = "film")
    protected List<JaxbFilmLink> films;

    /**
     * Gets the value of the films property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the films property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilms().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JaxbFilmLink }
     *
     *
     */
    public List<JaxbFilmLink> getFilms() {
        if (films == null) {
            films = new ArrayList<JaxbFilmLink>();
        }
        return this.films;
    }

}
