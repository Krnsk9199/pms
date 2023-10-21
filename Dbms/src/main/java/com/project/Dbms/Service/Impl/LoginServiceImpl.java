package com.project.Dbms.Service.Impl;

import com.project.Dbms.DTO.LoginDTO;
import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.Domain.PmsUser;
import com.project.Dbms.Repository.UserRepository;
import com.project.Dbms.Service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Log4j2
public class LoginServiceImpl implements LoginService {

    @Autowired
    public UserRepository userRepository;
    @Override
    public MessageDTO authenticate(LoginDTO loginDTO) {

        MessageDTO message = new MessageDTO();
        message.setData(true);
        message.setMessage("Logged in successfully");
        message.setStatus("success");


        String username = loginDTO.getUsername();
        Optional<PmsUser> userOptional = userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            PmsUser user = userOptional.get();
            if(!loginDTO.getPassword().equalsIgnoreCase(user.getPassword())){
                message.setMessage("Incorrect Password");
                message.setData(false);
            }
            else{
                message.setData(user);
            }
            return message;
        }
        message.setMessage("User not found");
        message.setData(false);
        return message;

    }
}
