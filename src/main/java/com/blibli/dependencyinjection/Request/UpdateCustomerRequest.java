package com.blibli.dependencyinjection.Request;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class UpdateCustomerRequest {

    @Length(max = 50)
    @NotBlank
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
