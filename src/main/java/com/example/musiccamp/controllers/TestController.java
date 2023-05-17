package com.example.musiccamp.controllers;

import com.example.musiccamp.AWSS3.S3Service;
import com.example.musiccamp.registration.RegistrationService;
import com.example.musiccamp.registration.user.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//@RequestMapping("api/v1/")
@Controller
public class TestController {
    @Autowired
    RegistrationService registrationService;
    @Autowired
    S3Service s3Service;

    @RequestMapping(value = "api/v1/welcome",method = RequestMethod.GET)
    public String getLandingPage(){
        return"landingPage";
    }
    @RequestMapping(value = "api/v1/registration",method = RequestMethod.POST)
    public String addUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        //String profilePicUrl = profilePicFile.getOriginalFilename();
        //String profilePic = "https://music-camp.s3.eu-north-1.amazonaws.com/"+profilePicUrl;
        //userRegistrationRequest.setProfilePic(profilePic);
        registrationService.register(userRegistrationRequest);
        //s3Service.saveFile(profilePicFile);
        return "landingPage";
    }


    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream( convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }





}
