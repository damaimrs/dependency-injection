package com.blibli.dependencyinjection.Service;

import com.blibli.dependencyinjection.Model.Address;

import java.util.ArrayList;
import java.util.List;

public interface AddressService {

    Address register(String street, String country, String province, String idCustomer);
    ArrayList<Address> getAll(String idCustomer);
    Address findAddressById(String idAddress, String idCustomer);
    Address update(String idAddress, String street, String country, String province, String idCustomer);
    void delete(String idAddress, String idCustomer);
}
