package main.java.com.veena.hello.dvo;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by veenanairv on 4/12/2017.
 */
@Entity
public class Category {
    private byte categoryId;
    private String name;
    private Timestamp lastUpdate;
    private Collection<FilmCategory> filmCategoriesByCategoryId;

    @Id
    @Column(name = "category_id", nullable = false)
    public byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(byte categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Category category = (Category) o;

        if (categoryId != category.categoryId) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(category.lastUpdate) : category.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) categoryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<FilmCategory> getFilmCategoriesByCategoryId() {
        return filmCategoriesByCategoryId;
    }

    public void setFilmCategoriesByCategoryId(Collection<FilmCategory> filmCategoriesByCategoryId) {
        this.filmCategoriesByCategoryId = filmCategoriesByCategoryId;
    }
}
