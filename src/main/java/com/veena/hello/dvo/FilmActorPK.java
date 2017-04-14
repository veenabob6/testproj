package main.java.com.veena.hello.dvo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by veenanairv on 4/12/2017.
 */
public class FilmActorPK implements Serializable {
    private short actorId;
    private short filmId;

    @Column(name = "actor_id", nullable = false)
    @Id
    public short getActorId() {
        return actorId;
    }

    public void setActorId(short actorId) {
        this.actorId = actorId;
    }

    @Column(name = "film_id", nullable = false)
    @Id
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmActorPK that = (FilmActorPK) o;

        if (actorId != that.actorId) return false;
        if (filmId != that.filmId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) actorId;
        result = 31 * result + (int) filmId;
        return result;
    }
}
