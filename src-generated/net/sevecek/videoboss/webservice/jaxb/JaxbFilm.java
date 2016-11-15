
package net.sevecek.videoboss.webservice.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <p>Java class for filmType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="filmType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="releaseYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="externalLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filmType", propOrder = {
    "id",
    "name",
    "releaseYear",
    "externalLink",
    "rating",
    "version"
})
@XmlRootElement(name = "film")
public class JaxbFilm {

    protected Long id;
    @XmlElement(required = true)
    protected String name;
    protected int releaseYear;
    @XmlElement(required = true)
    protected String externalLink;
    protected double rating;
    protected Integer version;

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the releaseYear property.
     *
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Sets the value of the releaseYear property.
     *
     */
    public void setReleaseYear(int value) {
        this.releaseYear = value;
    }

    /**
     * Gets the value of the externalLink property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getExternalLink() {
        return externalLink;
    }

    /**
     * Sets the value of the externalLink property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setExternalLink(String value) {
        this.externalLink = value;
    }

    /**
     * Gets the value of the rating property.
     *
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     *
     */
    public void setRating(double value) {
        this.rating = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setVersion(Integer value) {
        this.version = value;
    }

}
