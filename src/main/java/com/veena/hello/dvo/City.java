package main.java.com.veena.hello.dvo;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




/**
 * Created by veenanairv on 4/12/2017.
 */
@Entity
public class City {
    private short cityId;
    private String city;
    private short countryId;
    private Timestamp lastUpdate;
    private Collection<Address> addressesByCityId;
    private Country countryByCountryId;

    @Id
    @Column(name = "city_id", nullable = false)
    public short getCityId() {
        return cityId;
    }

    public void setCityId(short cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country_id", nullable = false)
    public short getCountryId() {
        return countryId;
    }

    public void setCountryId(short countryId) {
        this.countryId = countryId;
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

        City city1 = (City) o;

        if (cityId != city1.cityId) return false;
        if (countryId != city1.countryId) return false;
        if (city != null ? !city.equals(city1.city) : city1.city != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(city1.lastUpdate) : city1.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) cityId;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (int) countryId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Address> getAddressesByCityId() {
        return addressesByCityId;
    }

    public void setAddressesByCityId(Collection<Address> addressesByCityId) {
        this.addressesByCityId = addressesByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
