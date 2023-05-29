package com.geekster.InstagramProject.repo;


import com.geekster.InstagramProject.model.OtpAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOtpTokenRepo extends JpaRepository<OtpAuthenticationToken, Long> {
    OtpAuthenticationToken findByOtpToken(String token);
}
