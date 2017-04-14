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

/**S
 * Created by veenanairv on 4/12/2017.
 */
@Entity
public class Address {
    private short addressId;
    private String address;
    private String address2;
    private String district;
    private short cityId;
    private String postalCode;
    private String phone;
    private Timestamp lastUpdate;
    private City cityByCityId;
    private Collection<Customer> customersByAddressId;
    private Collection<Staff> staffByAddressId;
    private Collection<Store> storesByAddressId;

    @Id
    @Column(name = "address_id", nullable = false)
    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
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
    @Column(name = "address2", nullable = true, length = 50)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "district", nullable = false, length = 20)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city_id", nullable = false)
    public short getCityId() {
        return cityId;
    }

    public void setCityId(short cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "postal_code", nullable = true, length = 10)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

        Address address1 = (Address) o;

        if (addressId != address1.addressId) return false;
        if (cityId != address1.cityId) return false;
        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (address2 != null ? !address2.equals(address1.address2) : address1.address2 != null) return false;
        if (district != null ? !district.equals(address1.district) : address1.district != null) return false;
        if (postalCode != null ? !postalCode.equals(address1.postalCode) : address1.postalCode != null) return false;
        if (phone != null ? !phone.equals(address1.phone) : address1.phone != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(address1.lastUpdate) : address1.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) addressId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (int) cityId;
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", nullable = false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Customer> getCustomersByAddressId() {
        return customersByAddressId;
    }

    public void setCustomersByAddressId(Collection<Customer> customersByAddressId) {
        this.customersByAddressId = customersByAddressId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Staff> getStaffByAddressId() {
        return staffByAddressId;
    }

    public void setStaffByAddressId(Collection<Staff> staffByAddressId) {
        this.staffByAddressId = staffByAddressId;
    }

    @OneToMany(mappedBy = "addressByAddressId")
    public Collection<Store> getStoresByAddressId() {
        return storesByAddressId;
    }

    public void setStoresByAddressId(Collection<Store> storesByAddressId) {
        this.storesByAddressId = storesByAddressId;
    }
}
