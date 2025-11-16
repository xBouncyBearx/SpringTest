package com.example.springtest.Controller;

import com.example.springtest.Entity.LoginDetail;
import com.example.springtest.Repository.UserRepo;
import com.example.springtest.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    @Autowired
    public  AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody LoginDetail loginDetail){
        return authService.Register(loginDetail);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDetail loginDetail){
        return authService.Login(loginDetail);
    }

}
