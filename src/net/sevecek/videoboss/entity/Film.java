package net.sevecek.videoboss.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Films")
public class Film extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String externalLink;

    private int releaseYear;

    private double rating;

    @Version
    private int version;

    @OneToMany(mappedBy = "parentFilm")
    private List<MediaItem> mediaItems;

    //------------------------------------------------------------------------

    @Deprecated
    protected Film() {
    }

    public Film(Long id, String name, String externalLink, int releaseYear, double rating) {
        this.id = id;
        this.name = name;
        this.externalLink = externalLink;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Film(Long id, String name, String externalLink, int releaseYear, double rating, int version) {
        this.id = id;
        this.name = name;
        this.externalLink = externalLink;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.version = version;
    }

    public Film(Long id, int version) {
        this.id = id;
        this.version = version;
    }

    @Override
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String link) {
        this.externalLink = link;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<MediaItem> getMediaItems() {
        return mediaItems;
    }

    public void setMediaItems(List<MediaItem> mediaItems) {
        this.mediaItems = mediaItems;
    }

    //------------------------------------------------------------------------

    @Override
    protected boolean testInstanceOf(Object other) {
        return other instanceof Film;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + externalLink + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", version=" + version +
                '}';
    }

}
