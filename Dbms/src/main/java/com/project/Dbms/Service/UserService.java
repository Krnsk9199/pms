package com.project.Dbms.Service;

import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.DTO.UserDTO;
import org.aspectj.bridge.Message;

public interface UserService {
    void addUser(UserDTO userDTO);

    MessageDTO deleteUser(UserDTO userDTO);
}
