package com.blibli.dependencyinjection.Controller;

import com.blibli.dependencyinjection.Model.Address;
import com.blibli.dependencyinjection.Request.RegisterAddressRequest;
import com.blibli.dependencyinjection.Request.UpdateAddressRequest;
import com.blibli.dependencyinjection.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping(
            value = "/api/customer/{customerId}/address",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Address register(@PathVariable String customerId,
                            @Valid @RequestBody RegisterAddressRequest registerAddressRequest){

        String street = registerAddressRequest.getStreet();
        String country = registerAddressRequest.getCountry();
        String province = registerAddressRequest.getProvince();

        return addressService.register(street, country, province, customerId);
    }

    @GetMapping(
            value = "/api/customer/{customerId}/address/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Address getAddressesByAddressIdAndCustomerId(@PathVariable String customerId,
                                                        @PathVariable String addressId){

        return addressService.findAddressById(addressId, customerId);
    }

    @GetMapping(
            value = "/api/customer/{customerId}/address",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Address> getAddressesByCustomerId(@PathVariable String customerId){

        return addressService.getAll(customerId);
    }

    @PutMapping(
            value = "/api/customer/{customerId}/address/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Address update(@PathVariable String customerId,
                          @PathVariable String addressId,
                          @Valid @RequestBody UpdateAddressRequest updateAddressRequest){

        String street = updateAddressRequest.getStreet();
        String country = updateAddressRequest.getCountry();
        String province = updateAddressRequest.getProvince();

        return addressService.update(addressId, street, country, province, customerId);
    }

    @DeleteMapping(
            value = "/api/customer/{customerId}/address/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable String customerId, @PathVariable String addressId){

        addressService.delete(addressId, customerId);
    }

}
