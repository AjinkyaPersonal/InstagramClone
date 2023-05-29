package com.geekster.InstagramProject.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Otp_table")
public class OtpUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otpId;

    private String userEmail;

    private String otp;

    public OtpUser(String email, String otp) {
        this.userEmail = email;
        this.otp = otp;
    }
}
