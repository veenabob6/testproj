package main.java.com.veena.hello.dvo;


import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 



/**
 * Created by veenanairv on 4/12/2017.
 */
@Entity
@Table(name = "film_actor", schema = "sakila", catalog = "")
@IdClass(FilmActorPK.class)
public class FilmActor {
    private short actorId;
    private short filmId;
    private Timestamp lastUpdate;
    private Actor actorByActorId;
    private Film filmByFilmId;

    @Id
    @Column(name = "actor_id", nullable = false)
    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    @Id
    @Column(name = "film_id", nullable = false)
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "last_update", nullable = false)
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmActor filmActor = (FilmActor) o;

        if (actorId != filmActor.actorId) return false;
        if (filmId != filmActor.filmId) return false;
        if (lastUpdate != null ? !lastUpdate.equals(filmActor.lastUpdate) : filmActor.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) actorId;
        result = 31 * result + (int) filmId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id", nullable = false)
    public Actor getActorByActorId() {
        return actorByActorId;
    }

    public void setActorByActorId(Actor actorByActorId) {
        this.actorByActorId = actorByActorId;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film filmByFilmId) {
        this.filmByFilmId = filmByFilmId;
    }
}
