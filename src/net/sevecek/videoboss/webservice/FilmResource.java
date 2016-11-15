package net.sevecek.videoboss.webservice;

import java.util.*;
import javax.persistence.*;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import net.sevecek.videoboss.dao.*;
import net.sevecek.videoboss.entity.*;
import net.sevecek.videoboss.util.*;
import net.sevecek.videoboss.webservice.jaxb.*;

@Controller
@RequestMapping("/films")
public class FilmResource {

    private FilmRepository filmRepository;
    private JaxbTranslator jaxbTranslator;

    public FilmResource(FilmRepository filmRepository, JaxbTranslator jaxbTranslator) {
        this.filmRepository = filmRepository;
        this.jaxbTranslator = jaxbTranslator;
    }

    @RequestMapping(value = "/all{ext:\\..+}", method = RequestMethod.GET)
    public @ResponseBody JaxbFilmIdsList findAllFilms2(
            @RequestParam(value = "first", defaultValue = "0") long first,
            @RequestParam(value = "count", defaultValue = "-1") int count,
            @RequestParam(value = "name", required = false) String name,
            @PathVariable("ext") String extension) {
        List<Long> filmIds;
        if (name == null) {
            filmIds = filmRepository.findAll(first, count);
        } else {
            filmIds = filmRepository.findByName(name, first, count);
        }
        JaxbFilmIdsList jaxbFilmsList = jaxbTranslator.translateFilmIds(filmIds, extension);
        return jaxbFilmsList;
    }


/*
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody JaxbFilmIdsList findAllFilms() {
        List<Long> filmIds = filmRepository.findAll(0L, -1);
        JaxbFilmIdsList jaxbFilmsList = jaxbTranslator.translateFilmIds(filmIds, "");
        return jaxbFilmsList;
    }
*/

    //------------------------------------------------------------------------

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.GET)
    public ResponseEntity<JaxbFilm> findFilmById(
            @PathVariable("id") Long id) {
        Film film = filmRepository.findById(id);
        JaxbFilm jaxbFilm = jaxbTranslator.translateFilmWithoutVersion(film);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add(HttpHeaders.ETAG, Integer.toString(film.getVersion()));
        return new ResponseEntity<>(jaxbFilm, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{ids:(?:\\d+,)*\\d+}", method = RequestMethod.GET)
    public ResponseEntity<JaxbFilmList> findFilmsByIds(
            @PathVariable("ids") List<Long> ids) {
        List<Film> films = filmRepository.findByIds(ids);
        JaxbFilmList jaxbFilmList = jaxbTranslator.translateFilms(films);
        return new ResponseEntity<>(jaxbFilmList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id:\\d+}/picture", method = RequestMethod.GET)
    public ResponseEntity<Resource> findFilmPicture(@PathVariable("id") Long id) {
        Resource filmPicture = filmRepository.findFilmPicture(id);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(filmPicture, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<JaxbFilm> addFilm(
            @RequestBody JaxbFilm inputJaxbFilm) {
        Film inputFilm = jaxbTranslator.translateJaxbFilm(inputJaxbFilm, 0);
        Film addedFilm = filmRepository.addFilm(inputFilm);
        JaxbFilm resultJaxbFilm = jaxbTranslator.translateFilmWithoutVersion(addedFilm);
        return new ResponseEntity<>(resultJaxbFilm, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id:\\d+}", method = RequestMethod.PUT)
    public ResponseEntity<JaxbFilm> updateFilm(
            @PathVariable("id") Long id,
            @RequestHeader(HttpHeaders.IF_MATCH) int version,
            @RequestBody JaxbFilm inputJaxbFilm) {
        inputJaxbFilm.setId(id);
        Film inputFilm = jaxbTranslator.translateJaxbFilm(inputJaxbFilm, version);

        try {
            Film updatedFilm = filmRepository.updateFilm(inputFilm);
            JaxbFilm resultJaxbFilm = jaxbTranslator.translateFilmWithoutVersion(updatedFilm);
            return new ResponseEntity<>(resultJaxbFilm, HttpStatus.OK);
        } catch (OptimisticLockException ex) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteFilm(
            @PathVariable("id") long id,
            @RequestHeader(HttpHeaders.IF_MATCH) int version) {
        try {
            filmRepository.deleteFilm(new Film(id, version));
            return new ResponseEntity<>((Void)null, HttpStatus.NO_CONTENT);
        } catch (OptimisticLockException ex) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

}
