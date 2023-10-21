package com.project.Dbms.Controller;


import com.project.Dbms.DTO.LoginDTO;
import com.project.Dbms.DTO.MessageDTO;
import com.project.Dbms.Service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Validated

public class LoginController {

    @Autowired
    private  LoginService loginService;
    @PostMapping
    public Object login(@RequestBody LoginDTO loginDTO){
        MessageDTO message = loginService.authenticate(loginDTO);
        return message;
    }

}
