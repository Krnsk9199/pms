package com.project.Dbms.Service.Impl;


import com.project.Dbms.DTO.UserDTO;
import com.project.Dbms.Domain.PmsUser;
import com.project.Dbms.Repository.UserRepository;
import com.project.Dbms.Service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;
    @Override
    public void addUser(UserDTO userDTO) {

        log.info("Adding a new User");
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
        log.info(userDTO.getName() + "successfully added");

    }

    @Override
    public void deleteUser(UserDTO userDTO) {

    }
}
