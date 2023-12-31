package com.project.Dbms.Domain;


import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "pmsUser")
@Data
@ToString

public class PmsUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "mobile")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

}