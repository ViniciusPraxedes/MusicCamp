package com.example.musiccamp.registration;
import com.example.musiccamp.AWSS3.S3Service;
import com.example.musiccamp.registration.user.UserRegistrationRequest;
import com.example.musiccamp.registration.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/registration")
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    @Autowired
    S3Service s3Service;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String addUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        String token  = registrationService.register(userRegistrationRequest);
        return token;
    }

    @PostMapping(path = "file")
    public String addPic(@RequestParam("profilePic") MultipartFile profilePicFile, @RequestParam("email") String email){
        String originalFilename = profilePicFile.getOriginalFilename();
        String profilePicUrl = "https://music-camp.s3.eu-north-1.amazonaws.com/"+originalFilename;
        userRepository.changeProfilePic(email, profilePicUrl);
        s3Service.saveFile(profilePicFile);
        return "Success";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

}