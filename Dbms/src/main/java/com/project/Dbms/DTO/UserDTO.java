package com.project.Dbms.DTO;


import lombok.Data;
import lombok.ToString;

@Data
@ToString

public class UserDTO {
    private String name;
    private String role;
    private String dob;
    private String mobile;
    private String email;
    private String username;
    private String password;
    private String address;
}
