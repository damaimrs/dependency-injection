package com.blibli.dependencyinjection.Implementation;

import com.blibli.dependencyinjection.Model.Address;
import com.blibli.dependencyinjection.Model.Customer;
import com.blibli.dependencyinjection.Repository.AddressRepository;
import com.blibli.dependencyinjection.Repository.CustomerRepository;
import com.blibli.dependencyinjection.Service.AddressService;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImplementation implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address register(String street, String country, String province, String idCustomer) {

        Address address = new Address();
        Customer customer = new Customer();

        customer.setIdCustomer(idCustomer);

        address.setIdAddress(UUID.randomUUID().toString());
        address.setStreet(street);
        address.setCountry(country);
        address.setProvince(province);
        address.setCustomer(customer);

        return addressRepository.save(address);
    }

    @Override
    public ArrayList<Address> getAll(String idCustomer) {
        return addressRepository.findAddressByCustomer_IdCustomer(idCustomer);
    }

    @Override
    public Address findAddressById(String idAddress, String idCustomer) {

        return addressRepository.findAddressByIdAddressAndCustomer_IdCustomer(idAddress, idCustomer);
    }

    @Override
    public Address update(String idAddress, String street, String country, String province, String idCustomer) {

        Address address = new Address();
        address = addressRepository.findAddressByIdAddressAndCustomer_IdCustomer(idAddress, idCustomer);

        address.setStreet(street);
        address.setCountry(country);
        address.setProvince(province);

        return addressRepository.save(address);
    }

    @Override
    public void delete(String idAddress, String idCustomer) {

        Address address = new Address();

        address = addressRepository.findAddressByIdAddressAndCustomer_IdCustomer(idAddress, idCustomer);
        addressRepository.delete(address);
    }


}
