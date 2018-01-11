package com.blibli.dependencyinjection.Repository;

import com.blibli.dependencyinjection.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address,String> {

    Address findAddressByIdAddressAndCustomer_IdCustomer(String idAddress, String idCustomer);
    ArrayList<Address> findAddressByCustomer_IdCustomer(String idCustomer);
}
