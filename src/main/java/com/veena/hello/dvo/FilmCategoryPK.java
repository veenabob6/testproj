package main.java.com.veena.hello.dvo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by veenanairv on 4/12/2017.
 */
public class FilmCategoryPK implements Serializable {
    private short filmId;
    private byte categoryId;

    @Column(name = "film_id", nullable = false)
    @Id
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Column(name = "category_id", nullable = false)
    @Id
    public byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(byte categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmCategoryPK that = (FilmCategoryPK) o;

        if (filmId != that.filmId) return false;
        if (categoryId != that.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) filmId;
        result = 31 * result + (int) categoryId;
        return result;
    }
}
