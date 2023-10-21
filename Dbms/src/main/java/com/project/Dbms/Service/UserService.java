package com.project.Dbms.Service;

import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.DTO.UserDTO;
import com.project.Dbms.Domain.PmsUser;
import org.aspectj.bridge.Message;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO);

    MessageDTO deleteUser(UserDTO userDTO);

    List<PmsUser> viewUser();
}
