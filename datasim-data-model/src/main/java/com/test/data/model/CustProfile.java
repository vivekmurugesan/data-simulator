package com.test.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

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
    private Date DOB;
    private int age;

    public CustProfile() {
    }

    public void setDOB(Date dob){
        this.DOB = dob;
        Date currentDate = new Date(System.currentTimeMillis());
        this.age = currentDate.toLocalDate().getYear() -
                this.DOB.toLocalDate().getYear();
    }

    /*public CustProfile(long id, String firstName, String lastName, String PAN, String passportNo) {
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
    }*/
}
