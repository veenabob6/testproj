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
public class Store {
    private byte storeId;
    private byte managerStaffId;
    private short addressId;
    private Timestamp lastUpdate;
    private Collection<Customer> customersByStoreId;
    private Collection<Inventory> inventoriesByStoreId;
    private Collection<Staff> staffByStoreId;
    private Staff staffByManagerStaffId;
    private Address addressByAddressId;

    @Id
    @Column(name = "store_id", nullable = false)
    public byte getStoreId() {
        return storeId;
    }

    public void setStoreId(byte storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "manager_staff_id", nullable = false)
    public byte getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(byte managerStaffId) {
        this.managerStaffId = managerStaffId;
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

        Store store = (Store) o;

        if (storeId != store.storeId) return false;
        if (managerStaffId != store.managerStaffId) return false;
        if (addressId != store.addressId) return false;
        if (lastUpdate != null ? !lastUpdate.equals(store.lastUpdate) : store.lastUpdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) storeId;
        result = 31 * result + (int) managerStaffId;
        result = 31 * result + (int) addressId;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<Customer> getCustomersByStoreId() {
        return customersByStoreId;
    }

    public void setCustomersByStoreId(Collection<Customer> customersByStoreId) {
        this.customersByStoreId = customersByStoreId;
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<Inventory> getInventoriesByStoreId() {
        return inventoriesByStoreId;
    }

    public void setInventoriesByStoreId(Collection<Inventory> inventoriesByStoreId) {
        this.inventoriesByStoreId = inventoriesByStoreId;
    }

    @OneToMany(mappedBy = "storeByStoreId")
    public Collection<Staff> getStaffByStoreId() {
        return staffByStoreId;
    }

    public void setStaffByStoreId(Collection<Staff> staffByStoreId) {
        this.staffByStoreId = staffByStoreId;
    }

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
    public Staff getStaffByManagerStaffId() {
        return staffByManagerStaffId;
    }

    public void setStaffByManagerStaffId(Staff staffByManagerStaffId) {
        this.staffByManagerStaffId = staffByManagerStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
