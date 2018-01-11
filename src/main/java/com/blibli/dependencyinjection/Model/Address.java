package com.blibli.dependencyinjection.Model;

import javax.persistence.*;

@Entity
@Table
public class Address {

    @Id
    @Column(name = "id_address")
    @GeneratedValue
    private String idAddress;

    @Column(name = "street_address")
    private String street;

    @Column(name = "country_address")
    private String country;

    @Column(name = "province")
    private String province;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    Customer customer;

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
