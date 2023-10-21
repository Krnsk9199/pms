package com.project.Dbms.Controller;

import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.DTO.UserDTO;
import com.project.Dbms.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    @PostMapping("/delete")
    public  Object deleteUser(@RequestBody UserDTO userDTO){
        userService.deleteUser(userDTO);
        MessageDTO message = new MessageDTO();
        message.setData(null);
        message.setMessage(userDTO.getName() +" deleted successfully");
        message.setStatus("success");
        return message;
    }


}
