package com.geekster.InstagramProject.controller;

import com.geekster.InstagramProject.dto.SignInInput;
import com.geekster.InstagramProject.dto.SignInOutput;
import com.geekster.InstagramProject.dto.SignUpOutput;
import com.geekster.InstagramProject.model.PostLike;
import com.geekster.InstagramProject.model.User;
import com.geekster.InstagramProject.repo.IFollowingRepo;
import com.geekster.InstagramProject.service.OtpAuthenticationService;
import com.geekster.InstagramProject.service.TokenService;
import com.geekster.InstagramProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService authService;

    @Autowired
    IFollowingRepo followRepo;

    @Autowired
    OtpAuthenticationService otpAuthenticationService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpOutput> signUp(@Valid @RequestBody User signUpDto, @RequestParam String token){

        HttpStatus status;
        SignUpOutput output = null;
        if ( otpAuthenticationService.authenticateToken(signUpDto, token) ) {
            output = userService.signUp(signUpDto);
            status = HttpStatus.OK;
        }
        else {
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(output, status);

    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){

        return userService.signIn(signInDto);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg;

        if(authService.authenticate(email,token))
        {
            authService.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<>(msg, status);
    }

    @PutMapping()
    public ResponseEntity<String> updateUser(@RequestParam String email , @RequestParam String token , @RequestBody User user){
        HttpStatus status;
        String msg;

        if(authService.authenticate(email,token))
        {
            try{
                userService.updateUser(user , token);
                status = HttpStatus.OK;
                msg = "User updated successfully";
            }catch (Exception e){
                msg = "Enter valid information";
                status = HttpStatus.BAD_REQUEST;
            }

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<>(msg, status);
    }



    @PostMapping("/follow/{myId}/{otherId}")
    String followUser(@PathVariable Long myId, @PathVariable Long otherId)
    {
        return userService.followUser( myId, otherId);
    }


    @PostMapping("/like")
    void likePost(@RequestBody PostLike postLike)
    {
        //todo : validation
        userService.like(postLike);

    }







}
