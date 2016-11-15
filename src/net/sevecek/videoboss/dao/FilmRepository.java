package net.sevecek.videoboss.dao;

import java.util.List;
import org.springframework.core.io.*;
import net.sevecek.videoboss.entity.Film;

public interface FilmRepository {

    List<Long> findAll(long firstItem, int count);

    List<Long> findByName(String name, long firstItem, int count);

    Film findById(Long id);

    List<Film> findByIds(List<Long> ids);

    Film addFilm(Film newFilm);

    Film updateFilm(Film updatedFilm);

    void deleteFilm(Film idAndVersion);

    Resource findFilmPicture(Long id);

}
