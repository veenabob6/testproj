package main.java.com.veena.hello.dvo;

import java.sql.Timestamp;
import java.util.Arrays;
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
public class Staff {
    private byte staffId;
    private String firstName;
    private String lastName;
    private short addressId;
    private byte[] picture;
    private String email;
    private byte storeId;
    private byte active;
    private String username;
    private String password;
    private Timestamp lastUpdate;
    private Collection<Payment> paymentsByStaffId;
    private Collection<Rental> rentalsByStaffId;
    private Address addressByAddressId;
    private Store storeByStoreId;
    private Collection<Store> storesByStaffId;

    @Id
    @Column(name = "staff_id", nullable = false)
    public byte getStaffId() {
        return staffId;
    }

    public void setStaffId(byte staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "address_id", nullable = false)
    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "picture", nullable = true)
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "active", nullable = false)
    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 16)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        Staff staff = (Staff) o;

        if (staffId != staff.staffId) return false;
        if (addressId != staff.addressId) return false;
        if (storeId != staff.storeId) return false;
        if (active != staff.active) return false;
        if (firstName != null ? !firstName.equals(staff.firstName) : staff.firstName != null) return false;
        if (lastName != null ? !lastName.equals(staff.lastName) : staff.lastName != null) return false;
        if (!Arrays.equals(picture, staff.picture)) return false;
        if (email != null ? !email.equals(staff.email) : staff.email != null) return false;
        if (username != null ? !username.equals(staff.username) : staff.username != null) return false;
        if (password != null ? !password.equals(staff.password) : staff.password != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(staff.lastUpdate) : staff.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) staffId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) addressId;
        result = 31 * result + Arrays.hashCode(picture);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) storeId;
        result = 31 * result + (int) active;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<Payment> getPaymentsByStaffId() {
        return paymentsByStaffId;
    }

    public void setPaymentsByStaffId(Collection<Payment> paymentsByStaffId) {
        this.paymentsByStaffId = paymentsByStaffId;
    }

    @OneToMany(mappedBy = "staffByStaffId")
    public Collection<Rental> getRentalsByStaffId() {
        return rentalsByStaffId;
    }

    public void setRentalsByStaffId(Collection<Rental> rentalsByStaffId) {
        this.rentalsByStaffId = rentalsByStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    @OneToMany(mappedBy = "staffByManagerStaffId")
    public Collection<Store> getStoresByStaffId() {
        return storesByStaffId;
    }

    public void setStoresByStaffId(Collection<Store> storesByStaffId) {
        this.storesByStaffId = storesByStaffId;
    }
}
