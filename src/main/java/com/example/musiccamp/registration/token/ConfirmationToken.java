package com.example.musiccamp.registration.token;

import com.example.musiccamp.Album;
import com.example.musiccamp.registration.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id")
    private Long Id;
    private String token;
    private LocalDateTime generatedAt;
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    public ConfirmationToken(String token, LocalDateTime generatedAt, LocalDateTime expiredAt, User user) {
        this.token = token;
        this.generatedAt = generatedAt;
        this.expiresAt = expiredAt;
        this.user = user;
    }
}

