package com.example.springtest.Service;

import com.example.springtest.Entity.LoginDetail;
import com.example.springtest.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepo userRepo;
    private final JwtService jwtService;
    @Autowired
    public AuthService(UserRepo userRepo, JwtService jwtService) {
        this.userRepo = userRepo;
        this.jwtService = jwtService;
    }

    public String Register(LoginDetail loginDetail) {
        if(userRepo.findByUsername(loginDetail.getUsername())!=null){
           return "user exists";
        }
        userRepo.save(loginDetail);
        return "success";
    }

    public String Login(LoginDetail loginDetail) {
        LoginDetail user = userRepo.findByUsername(loginDetail.getUsername());
        if(user == null) {
            return "user not found";
        }
        if(!user.getPassword().equals(loginDetail.getPassword())) {
            return "invalid password";
        }else{
            return jwtService.generateToken(loginDetail.getUsername());
        }
    }
}
