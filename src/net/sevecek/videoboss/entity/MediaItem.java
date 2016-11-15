package net.sevecek.videoboss.entity;

import javax.persistence.*;

@Entity
@Table(name = "MediaItems")
public class MediaItem extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="BranchID")
    private Branch homeBranch;

    @ManyToOne
    @JoinColumn(name = "FilmID")
    private Film parentFilm;

    private boolean available;

    @Version
    private int version;

    //------------------------------------------------------------------------

    @Deprecated
    protected MediaItem() {
    }

    public MediaItem(Long id, Branch homeBranch, Film parentFilm) {
        this.id = id;
        this.homeBranch = homeBranch;
        this.parentFilm = parentFilm;
        this.available = true;
    }

    public MediaItem(Long id, Branch homeBranch, Film parentFilm, boolean available, int version) {
        this.id = id;
        this.homeBranch = homeBranch;
        this.parentFilm = parentFilm;
        this.available = available;
        this.version = version;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Branch getHomeBranch() {
        return homeBranch;
    }

    public void setHomeBranch(Branch homeBranch) {
        this.homeBranch = homeBranch;
    }

    public boolean isAvailable() {
        return available;
    }

    public Film getParentFilm() {
        return parentFilm;
    }

    public void setParentFilm(Film parentFilm) {
        this.parentFilm = parentFilm;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    //------------------------------------------------------------------------

    @Override
    protected boolean testInstanceOf(Object other) {
        return other instanceof MediaItem;
    }


    @Override
    public String toString() {
        return "MediaItem{" +
                "id=" + id +
                ", homeBranch=" + homeBranch +
                ", available=" + available +
                ", version=" + version +
                '}';
    }
}
