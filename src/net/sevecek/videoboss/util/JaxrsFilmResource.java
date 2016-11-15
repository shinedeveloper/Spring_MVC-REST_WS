package net.sevecek.videoboss.util;

import java.util.*;
import javax.ws.rs.*;
import net.sevecek.videoboss.dao.*;
import net.sevecek.videoboss.webservice.jaxb.*;

@Path("/films")
public class JaxrsFilmResource {

    private FilmRepository filmRepository;
    private JaxbTranslator jaxbTranslator;

    @GET
    @Path("/all")
    public JaxbFilmIdsList findAllFilms(
            @QueryParam("first") long first,
            @QueryParam("count") int count,
            @QueryParam("name") String name) {
        List<Long> filmIds;
        if (name == null) {
            filmIds = filmRepository.findAll(first, count);
        } else {
            filmIds = filmRepository.findByName(name, first, count);
        }
        JaxbFilmIdsList jaxbFilmsList = jaxbTranslator.translateFilmIds(filmIds, ".xml");
        return jaxbFilmsList;
    }

}
