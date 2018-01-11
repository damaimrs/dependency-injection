package com.blibli.dependencyinjection.Request;

import org.hibernate.validator.constraints.NotBlank;

public class UpdateAddressRequest {

    @NotBlank
    String street;

    @NotBlank
    String country;

    @NotBlank
    String province;

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
}
