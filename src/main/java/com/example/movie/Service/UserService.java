package com.example.movie.Service;

import com.example.movie.Request.AuthRequest;
import com.example.movie.Model.User;
import com.example.movie.Repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).
                orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public void createUser(User user) {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new IllegalStateException("User with username " + user.getUsername() + " already exists");
        }
    }

    public void deleteUser(Long id) {
        boolean exists = userRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepo.deleteById(id);
    }

    public void updateUser(Long id, User user) {
        User userToUpdate = userRepo.findById(id).
                orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userRepo.save(userToUpdate);
    }

    public void changePassword(Long id, String password) {
        User userToUpdate = userRepo.findById(id).
                orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
        userToUpdate.setPassword(password);
        userRepo.save(userToUpdate);
    }

    public User signUp(AuthRequest authRequest) {
        if (!authRequest.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (authRequest.getPassword().length() < 8 || !authRequest.getPassword().matches(".*[!@#$%^&*()].*")) {
            throw new IllegalArgumentException("Password must be at least 8 characters long and contain at least one special character");
        }

        if (authRequest.getUsername() == null || authRequest.getUsername().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        if (userRepo.findByEmail(authRequest.getEmail()) == null) {
            User user = new User();
            user.setUsername(authRequest.getUsername());
            user.setEmail(authRequest.getEmail());
            user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
            if (authRequest.getRole() == null) {
                user.setRole(User.Role.USER);
            } else {
                try {
                    user.setRole(User.Role.valueOf(authRequest.getRole()));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid role");
                }
            }
            return userRepo.save(user);
        } else {
            throw new IllegalArgumentException("Email already exists");
        }
    }


}
