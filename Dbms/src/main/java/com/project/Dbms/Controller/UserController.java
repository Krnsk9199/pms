package com.project.Dbms.Controller;

import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.DTO.UserDTO;
import com.project.Dbms.Domain.PmsUser;
import com.project.Dbms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
@Validated

public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public Object addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage("New User addedd successfully");
        message.setStatus("success");
        return message;
    }

    @PostMapping("/remove")
    public  Object deleteUser(@RequestBody UserDTO userDTO){
       MessageDTO message =  userService.deleteUser(userDTO);
       return message;
    }

    @PostMapping("/view")
    public  Object viewUser(@RequestBody UserDTO userDTO){
        List<PmsUser> users = userService.viewUser();
        MessageDTO message = new MessageDTO();
        message.setData(users);
        message.setMessage("All users fetched successfully");
        message.setStatus("success");
        return message;
    }


    @PostMapping("/update")
    public  Object updateUser(@RequestBody UserDTO userDTO){
        userService.updatedUser(userDTO);
        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage("User updated successfully");
        message.setStatus("success");
        return message;
    }

}
