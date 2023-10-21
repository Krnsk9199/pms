package com.project.Dbms.Service.Impl;


import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.DTO.UserDTO;
import com.project.Dbms.Domain.PmsUser;
import com.project.Dbms.Repository.UserRepository;
import com.project.Dbms.Service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;
    @Override
    public void addUser(UserDTO userDTO) {

        log.info("------------> Adding a new User <----------------");
        PmsUser newUser = new PmsUser();
        newUser.setRole(userDTO.getRole());
        newUser.setName(userDTO.getName());
        newUser.setAddress(userDTO.getAddress());
        newUser.setEmail(userDTO.getEmail());
        newUser.setMobile(userDTO.getMobile());
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());
        newUser.setDob(userDTO.getDob());
        userRepository.save(newUser);
        log.info("------------->" + userDTO.getName() + " successfully added <------------");

    }

    @Override
    public MessageDTO deleteUser(UserDTO userDTO) {

        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage(userDTO.getName() +" deleted successfully");
        message.setStatus("success");

        if(userDTO.getRole().equalsIgnoreCase("Admin")){
            message.setMessage("Cannot delete admin");
            return message;
        }
        String name = userDTO.getName();
        Long id = userDTO.getId();
        Optional<PmsUser> pmsUserOptional = userRepository.findById(id);
        if(pmsUserOptional.isPresent()){
            PmsUser user = pmsUserOptional.get();
            userRepository.delete(user);
            log.info(name + " deleted successfully");
            return message;
        }
        message.setMessage("user not found with the given name");
        return message;
    }
}
