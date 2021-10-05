package com.target.training.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender = "Male";
    private String email;
    private String phone;
    private String address;
    private String city = "Bangalore";
    private String state = "Karnataka";
    private Integer pinCode;
    private String country = "India";
    private Date birthDate;

}
