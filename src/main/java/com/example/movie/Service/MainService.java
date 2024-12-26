package com.example.movie.Service;

import com.example.movie.Repository.UserRepo;
import com.example.movie.Security.JwtUtil;
import com.example.movie.Model.User;

public class MainService {
    private final JwtUtil jwtUtil;
    private final UserRepo userRepo;

    public MainService(JwtUtil jwtUtil, UserRepo userRepo) {
        this.jwtUtil = jwtUtil;
        this.userRepo = userRepo;
    }

    public boolean isAdmin(String token) {
        String username = jwtUtil.extractUsername(token.substring(7));
        User user = userRepo.findByEmail(username);
        return user != null && user.getRole().equals(User.Role.ADMIN);
    }

    public boolean isUser(String token) {
        String username = jwtUtil.extractUsername(token.substring(7));
        User user = userRepo.findByEmail(username);
        return user != null && user.getRole().equals(User.Role.USER);
    }

    public boolean isUserAndAdmin(String token) {
        String username = jwtUtil.extractUsername(token.substring(7));
        User user = userRepo.findByEmail(username);
        return user != null && (user.getRole().equals(User.Role.USER) || user.getRole().equals(User.Role.ADMIN));
    }

    public static String generateCreatedAt() {
        return java.time.LocalDateTime.now().toString();
    }
}
