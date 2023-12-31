package com.caio.alura.api.model.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String postalCode;
    private String state;
    private String city;
    private String street;

    public Address(AddressRegisterData data) {
        this.postalCode = data.postalCode();
        this.state = data.state();
        this.city = data.city();
        this.street = data.street();
    }
    
}
