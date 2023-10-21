package com.project.Dbms.Service;

import com.project.Dbms.DTO.UserDTO;

public interface UserService {
    void addUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);
}
