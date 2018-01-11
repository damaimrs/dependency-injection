package com.blibli.dependencyinjection.Controller;

import com.blibli.dependencyinjection.Model.Customer;
import com.blibli.dependencyinjection.Request.RegisterCustomerRequest;
import com.blibli.dependencyinjection.Request.UpdateCustomerRequest;
import com.blibli.dependencyinjection.Service.CustomerService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(
            value = "/api/customer",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer registerPost(@Valid @RequestBody RegisterCustomerRequest registerCustomerRequest)
    {
        return customerService.register(registerCustomerRequest.getName());
    }

    @GetMapping(
            value = "/api/customers",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Customer> registerGet(){
        return customerService.getAll();
    }

    @GetMapping(
            value = "/api/customers/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer registerGetOne(@PathVariable String id){
        return customerService.findById(id);
    }

    @PutMapping(
            value = "/api/customers/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Customer updateCustomer(@PathVariable String id, @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest){

        return customerService.update(id, updateCustomerRequest.getName());
    }

    @DeleteMapping(
            value = "/api/customer/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteCustomer(@PathVariable String id){

        customerService.delete(id);
    }

}
