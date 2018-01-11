package com.blibli.dependencyinjection.Implementation;

import com.blibli.dependencyinjection.Model.Customer;
import com.blibli.dependencyinjection.Repository.CustomerRepository;
import com.blibli.dependencyinjection.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    @Override
    public Customer register(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setIdCustomer(UUID.randomUUID().toString());

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(String idCustomer) {
        return customerRepository.findOne(idCustomer);
    }

    @Override
    public Customer update(String idCustomer, String name) {
        Customer customer = customerRepository.getOne(idCustomer);

        customer.setName(name);

        return customerRepository.save(customer);
    }

    @Override
    public void delete(String idCustomer) {
        Customer customer = customerRepository.getOne(idCustomer);
        customerRepository.delete(idCustomer);
    }


}
