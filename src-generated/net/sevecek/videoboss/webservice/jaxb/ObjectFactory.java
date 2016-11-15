
package net.sevecek.videoboss.webservice.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.sevecek.videoboss.webservice.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Films_QNAME = new QName("urn:videoboss.sevecek.net", "films");
    private final static QName _Film_QNAME = new QName("urn:videoboss.sevecek.net", "film");
    private final static QName _FilmIds_QNAME = new QName("urn:videoboss.sevecek.net", "filmIds");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.sevecek.videoboss.webservice.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JaxbFilmList }
     * 
     */
    public JaxbFilmList createJaxbFilmList() {
        return new JaxbFilmList();
    }

    /**
     * Create an instance of {@link JaxbFilmIdsList }
     * 
     */
    public JaxbFilmIdsList createJaxbFilmIdsList() {
        return new JaxbFilmIdsList();
    }

    /**
     * Create an instance of {@link JaxbFilm }
     * 
     */
    public JaxbFilm createJaxbFilm() {
        return new JaxbFilm();
    }

    /**
     * Create an instance of {@link JaxbFilmLink }
     * 
     */
    public JaxbFilmLink createJaxbFilmLink() {
        return new JaxbFilmLink();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JaxbFilmList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:videoboss.sevecek.net", name = "films")
    public JAXBElement<JaxbFilmList> createFilms(JaxbFilmList value) {
        return new JAXBElement<JaxbFilmList>(_Films_QNAME, JaxbFilmList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JaxbFilm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:videoboss.sevecek.net", name = "film")
    public JAXBElement<JaxbFilm> createFilm(JaxbFilm value) {
        return new JAXBElement<JaxbFilm>(_Film_QNAME, JaxbFilm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JaxbFilmIdsList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:videoboss.sevecek.net", name = "filmIds")
    public JAXBElement<JaxbFilmIdsList> createFilmIds(JaxbFilmIdsList value) {
        return new JAXBElement<JaxbFilmIdsList>(_FilmIds_QNAME, JaxbFilmIdsList.class, null, value);
    }

}
