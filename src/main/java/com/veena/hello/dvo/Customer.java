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
public class Customer {
    private short customerId;
    private byte storeId;
    private String firstName;
    private String lastName;
    private String email;
    private short addressId;
    private byte active;
    private Timestamp createDate;
    private Timestamp lastUpdate;
    private Store storeByStoreId;
    private Address addressByAddressId;
    private Collection<Payment> paymentsByCustomerId;
    private Collection<Rental> rentalsByCustomerId;

    @Id
    @Column(name = "customer_id", nullable = false)
    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
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
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "active", nullable = false)
    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (storeId != customer.storeId) return false;
        if (addressId != customer.addressId) return false;
        if (active != customer.active) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (createDate != null ? !createDate.equals(customer.createDate) : customer.createDate != null) return false;
        if (lastUpdate != null ? !lastUpdate.equals(customer.lastUpdate) : customer.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) customerId;
        result = 31 * result + (int) storeId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) addressId;
        result = 31 * result + (int) active;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    public Store getStoreByStoreId() {
        return storeByStoreId;
    }

    public void setStoreByStoreId(Store storeByStoreId) {
        this.storeByStoreId = storeByStoreId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Payment> getPaymentsByCustomerId() {
        return paymentsByCustomerId;
    }

    public void setPaymentsByCustomerId(Collection<Payment> paymentsByCustomerId) {
        this.paymentsByCustomerId = paymentsByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Rental> getRentalsByCustomerId() {
        return rentalsByCustomerId;
    }

    public void setRentalsByCustomerId(Collection<Rental> rentalsByCustomerId) {
        this.rentalsByCustomerId = rentalsByCustomerId;
    }
}
