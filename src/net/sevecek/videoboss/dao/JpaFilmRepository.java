package net.sevecek.videoboss.dao;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.internal.*;
import org.springframework.core.io.*;
import org.springframework.transaction.annotation.*;
import net.sevecek.videoboss.entity.*;

@Transactional
public class JpaFilmRepository implements FilmRepository {

    private EntityManager entityManager;

    public JpaFilmRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Long> findAll(long firstItem, int count) {
        TypedQuery<Long> query = entityManager.createNamedQuery(
                "FindAllFilms",
                Long.class);
        if (firstItem > 0L) {
            query.setFirstResult((int) firstItem);
        }
        if (count > -1) {
            query.setMaxResults(count);
        }
        return query.getResultList();
    }

    @Override
    public List<Long> findByName(String name, long firstItem, int count) {
        TypedQuery<Long> query = entityManager.createNamedQuery(
                "FindFilmsByName",
                Long.class);
        query.setParameter("NAME", "%" + name + "%");
        if (firstItem > 0L) {
            query.setFirstResult((int) firstItem);
        }
        if (count > -1) {
            query.setMaxResults(count);
        }
        return query.getResultList();
    }

    @Override
    public Film findById(Long id) {
        TypedQuery<Film> query = entityManager.createNamedQuery(
                "FindFilmByID",
                Film.class);
        query.setParameter("ID", id);
        return query.getSingleResult();
    }

    @Override
    public List<Film> findByIds(List<Long> ids) {
        TypedQuery<Film> query = entityManager.createNamedQuery(
                "FindFilmsByID",
                Film.class);
        query.setParameter("IDs", ids);
        return query.getResultList();
    }

    @Override
    public Film addFilm(Film newFilm) {
        entityManager.persist(newFilm);
        return newFilm;
    }

    @Override
    public Film updateFilm(Film updatedFilm) {
        Film managedFilm = entityManager.merge(updatedFilm);
        return managedFilm;
    }

    @Override
    public void deleteFilm(Film idAndVersion) {
        Film managedFilm = findById(idAndVersion.getId());
        managedFilm.setVersion(idAndVersion.getVersion());
        entityManager.remove(managedFilm);
    }

    @Override
    public Resource findFilmPicture(Long id) {
        try {
            SessionImpl session = entityManager.unwrap(SessionImpl.class);
            Connection conn = session.connection();
            PreparedStatement query = conn.prepareStatement(
                        "select f.picture from FILMS f where f.ID = ?");
                query.setLong(1, id);
                ResultSet resultSet = query.executeQuery();
                if (resultSet.next()) {
                    Blob blob = resultSet.getBlob(1);
                    return new InputStreamResource(blob.getBinaryStream()) {
                        @Override
                        public long contentLength() throws IOException {
                            try {
                                return blob.length();
                            } catch (SQLException e) {
                                throw new IOException(e);
                            }
                        }
                    };
                } else {
                    throw new NoResultException("No picture for film (" + id + ")");
                }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

}
