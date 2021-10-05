package com.target.trianing.entity;


import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contact {

    private Integer id;
    private String firstname;
    private String lastname;
    private Gender gender = Gender.MALE;
    private String email;
    private String phone;
    private String address;
    private String city = "Bangalore";
    private String state = "Karnataka";
    private Integer pincode;
    private String country = "India";
    private Date birthDate;


}