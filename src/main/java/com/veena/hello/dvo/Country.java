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
public class Country {
    private short countryId;
    private String country;
    private Timestamp lastUpdate;
    private Collection<City> citiesByCountryId;

    @Id
    @Column(name = "country_id", nullable = false)
    public short getCountryId() {
        return countryId;
    }

    public void setCountryId(short countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

        Country country1 = (Country) o;

        if (countryId != country1.countryId) return false;
        if (country != null ? !country.equals(country1.country) : country1.country != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(country1.lastUpdate) : country1.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) countryId;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<City> getCitiesByCountryId() {
        return citiesByCountryId;
    }

    public void setCitiesByCountryId(Collection<City> citiesByCountryId) {
        this.citiesByCountryId = citiesByCountryId;
    }
}
