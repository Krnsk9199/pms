package com.project.Dbms.Service;

import com.project.Dbms.DTO.LoginDTO;
import com.project.Dbms.DTO.MessageDTO;
import org.aspectj.bridge.Message;

public interface LoginService {
    MessageDTO authenticate(LoginDTO loginDTO);
}
