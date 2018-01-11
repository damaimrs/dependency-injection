package com.blibli.dependencyinjection.Implementation;

import com.blibli.dependencyinjection.Model.Customer;
import com.blibli.dependencyinjection.Repository.CustomerRepository;
import com.blibli.dependencyinjection.Service.CustomerService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceImplementationTest {

    /**
     * JUnit akan menyerahkan kodingan dibawah @Rule ke MockitoRule
     */
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * mendeklarasikan objek yang akan dimock
     */
    @Mock
    CustomerRepository customerRepository;

    /**
     * menginject object yang akan dimock ke dalam object yang dideklarasikan dibawah anotasi InjectMock
     */
    @InjectMocks
    CustomerServiceImplementation customerService;

    @Test
    public void register_returnCustomer() throws Exception {

        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
                .then(invocation -> invocation.getArguments()[0]);
        Customer customer = customerService.register("Eko");

        assertNotNull(customer.getIdCustomer());
        assertEquals("Eko", customer.getName());

        Mockito.verify(customerRepository, Mockito.times(1)).save(Mockito.any(Customer.class));
    }

    @Test(expected = RuntimeException.class)
    public void register_returnError(){
        Mockito.when(customerRepository.save((Mockito.any(Customer.class))))
                .thenThrow(new RuntimeException());

        customerService.register("Eko");
    }

    @Test
    public void findAll_returnCustomers(){
        List<Customer> customers= new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setName("Eko");
        customers.add(customer);

        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        customers = customerService.getAll();
        assertEquals(customer.getName(), customers.get(0).getName());
    }

    @Test
    public void findById_returnCustomer(){
        List<Customer> customers= new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setName("Eko");
        customers.add(customer);

        Mockito.when(customerRepository.findOne(customers.get(0).getIdCustomer())).thenReturn(customer);

    }
}