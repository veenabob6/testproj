package main.java.com.veena.hello.dvo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by veenanairv on 4/12/2017.
 */
@Entity
@Table(name = "staff_list", schema = "sakila", catalog = "")
public class StaffList {
    private byte id;
    private String name;
    private String address;
    private String zipCode;
    private String phone;
    private String city;
    private String country;
    private byte sid;

    @Basic
    @Column(name = "ID", nullable = false)
    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 91)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zip code", nullable = true, length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "country", nullable = false, length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "SID", nullable = false)
    public byte getSid() {
        return sid;
    }

    public void setSid(byte sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffList staffList = (StaffList) o;

        if (id != staffList.id) return false;
        if (sid != staffList.sid) return false;
        if (name != null ? !name.equals(staffList.name) : staffList.name != null) return false;
        if (address != null ? !address.equals(staffList.address) : staffList.address != null) return false;
        if (zipCode != null ? !zipCode.equals(staffList.zipCode) : staffList.zipCode != null) return false;
        if (phone != null ? !phone.equals(staffList.phone) : staffList.phone != null) return false;
        if (city != null ? !city.equals(staffList.city) : staffList.city != null) return false;
        if (country != null ? !country.equals(staffList.country) : staffList.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (int) sid;
        return result;
    }
}
