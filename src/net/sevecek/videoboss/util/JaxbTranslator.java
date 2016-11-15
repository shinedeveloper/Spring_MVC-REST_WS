package net.sevecek.videoboss.util;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.client.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.webservice.jaxb.*;

public class JaxbTranslator {

    public List<Film> translateJaxbFilms(JaxbFilmList allJaxbFilms) {
        List<Film> allFilms = new ArrayList<>(allJaxbFilms.getFilms().size());
        for (JaxbFilm jaxbFilm : allJaxbFilms.getFilms()) {
            Film film = translateJaxbFilmWithVersion(jaxbFilm);
            allFilms.add(film);
        }
        return allFilms;
    }

    public Film translateJaxbFilm(JaxbFilm jaxbFilm, int version) {
        return new Film(
                jaxbFilm.getId(),
                jaxbFilm.getName(),
                jaxbFilm.getExternalLink(),
                jaxbFilm.getReleaseYear(),
                jaxbFilm.getRating(),
                version);
    }

    public Film translateJaxbFilmWithVersion(JaxbFilm jaxbFilm) {
        if (jaxbFilm.getVersion() == null) {
            throw new HttpClientErrorException(HttpStatus.PRECONDITION_REQUIRED);
        }
        return new Film(
                jaxbFilm.getId(),
                jaxbFilm.getName(),
                jaxbFilm.getExternalLink(),
                jaxbFilm.getReleaseYear(),
                jaxbFilm.getRating(),
                jaxbFilm.getVersion());
    }

    public JaxbFilmIdsList translateFilmIds(List<Long> filmIds, String extension) {
        JaxbFilmIdsList result = new JaxbFilmIdsList();
        List<JaxbFilmLink> allJaxbFilmLinks = result.getFilms();
        for (Long filmId : filmIds) {
            JaxbFilmLink jaxbFilmLinkType = new JaxbFilmLink();
            jaxbFilmLinkType.setHref(Long.toString(filmId) + extension);
            allJaxbFilmLinks.add(jaxbFilmLinkType);
        }
        return result;
    }

    public JaxbFilmList translateFilms(List<Film> films) {
        JaxbFilmList result = new JaxbFilmList();
        List<JaxbFilm> allJaxbFilms = result.getFilms();
        for (Film film : films) {
            JaxbFilm jaxbFilm = translateFilmWithVersion(film);
            allJaxbFilms.add(jaxbFilm);
        }
        return result;
    }

    public JaxbFilm translateFilmWithVersion(Film film) {
        JaxbFilm jaxbFilm = new JaxbFilm();
        jaxbFilm.setId(film.getId());
        jaxbFilm.setName(film.getName());
        jaxbFilm.setReleaseYear(film.getReleaseYear());
        jaxbFilm.setExternalLink(film.getExternalLink());
        jaxbFilm.setRating(film.getRating());
        jaxbFilm.setVersion(film.getVersion());
        return jaxbFilm;
    }

    public JaxbFilm translateFilmWithoutVersion(Film film) {
        JaxbFilm jaxbFilm = new JaxbFilm();
        jaxbFilm.setId(film.getId());
        jaxbFilm.setName(film.getName());
        jaxbFilm.setReleaseYear(film.getReleaseYear());
        jaxbFilm.setExternalLink(film.getExternalLink());
        jaxbFilm.setRating(film.getRating());
        return jaxbFilm;
    }

}
