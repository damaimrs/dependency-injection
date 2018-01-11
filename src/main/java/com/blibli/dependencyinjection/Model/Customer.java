package com.blibli.dependencyinjection.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id_customer")
    String idCustomer;

    @Column(name = "name_customer")
    String name;

//    @OneToMany(mappedBy = "customer")
//    private List<Address> address = new ArrayList<Address>();

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Address> getAddress() {
//        return address;
//    }
//
//    public void setAddress(List<Address> address) {
//        this.address = address;
//    }
}
