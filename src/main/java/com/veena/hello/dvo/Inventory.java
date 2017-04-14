package main.java.com.veena.hello.dvo;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by veenanairv on 4/12/2017.
 */
@Entity
public class Inventory {
    private short filmId;
    private byte storeId;
    private Timestamp lastUpdate;
    private Film filmByFilmId;
    private Store storeByStoreId;
    private Collection<Rental> rentalsByInventoryId;

    @Basic
    @Column(name = "film_id", nullable = false)
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "store_id", nullable = false)
    public byte getStoreId() {
        return storeId;
    }

    public void setStoreId(byte storeId) {
        this.storeId = storeId;
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

        Inventory inventory = (Inventory) o;

        if (filmId != inventory.filmId) return false;
        if (storeId != inventory.storeId) return false;
        if (lastUpdate != null ? !lastUpdate.equals(inventory.lastUpdate) : inventory.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) filmId;
        result = 31 * result + (int) storeId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film filmByFilmId) {
        this.filmByFilmId = filmByFilmId;
    }

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    @OneToMany(mappedBy = "inventoryByInventoryId")
    public Collection<Rental> getRentalsByInventoryId() {
        return rentalsByInventoryId;
    }

    public void setRentalsByInventoryId(Collection<Rental> rentalsByInventoryId) {
        this.rentalsByInventoryId = rentalsByInventoryId;
    }
}
