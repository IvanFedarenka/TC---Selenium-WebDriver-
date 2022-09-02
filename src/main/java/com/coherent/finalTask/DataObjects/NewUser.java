package com.coherent.finalTask.DataObjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUser {

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String mobilePhone;

    @Override
    public String toString() {
        return "NewUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                '}';
    }
}
