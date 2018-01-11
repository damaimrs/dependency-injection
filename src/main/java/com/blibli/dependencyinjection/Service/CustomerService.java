package com.blibli.dependencyinjection.Service;

import com.blibli.dependencyinjection.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {

    Customer register(String name);
    List<Customer> getAll();
    Customer findById(String idCustomer);
    Customer update(String idAddress, String name);
    void delete(String idCustomer);
}
