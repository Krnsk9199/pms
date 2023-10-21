package com.project.Dbms.DTO;


import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class UserDTO {
    private Long Id;
    private String name;
    private String role;
    private String dateOfBirth;
    private String mobileNumber;
    private String email;
    private String username;
    private String password;
    private String address;
}
