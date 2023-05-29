package com.geekster.InstagramProject.service;


import com.geekster.InstagramProject.model.OtpAuthenticationToken;
import com.geekster.InstagramProject.model.User;
import com.geekster.InstagramProject.repo.IOtpTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpAuthenticationService {

    @Autowired
    IOtpTokenRepo otpTokenRepo;


    public boolean authenticateToken(User signUpDto, String token) {
        OtpAuthenticationToken token1 = otpTokenRepo.findByOtpToken(token);
        if ( token1 != null ) {
            if(token1.getEmail().equals(signUpDto.getEmail())){
                return true;
            }
        }
        return false;
    }
}
