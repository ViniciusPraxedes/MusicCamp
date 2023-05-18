package com.example.musiccamp.registration.email;

public interface EmailSenderService {
    void sendEmail(String to,String subject, String email);
}
