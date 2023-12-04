package com.example.dw.entity.user;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {
    private String zipCode;
    private String address;
    private String detail;


    public Address(String zipCode, String address, String detail) {
        this.zipCode = zipCode;
        this.address = address;
        this.detail = detail;
    }
}
