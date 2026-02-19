package com.test.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustProfile {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String PAN;
    private String passportNo;

    public CustProfile() {
    }

    public CustProfile(long id, String firstName, String lastName, String PAN, String passportNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.PAN = PAN;
        this.passportNo = passportNo;
    }

    public CustProfile(String firstName, String lastName, String PAN, String passportNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PAN = PAN;
        this.passportNo = passportNo;
    }
}
