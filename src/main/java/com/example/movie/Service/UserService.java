package com.example.movie.Service;

import com.example.movie.Model.User;
import com.example.movie.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).
                orElseThrow(()-> new IllegalArgumentException("User with id " + id + " not found"));
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

    public void deleteUser(Long id){
        boolean exists = userRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepo.deleteById(id);
    }

    public void updateUser(Long id, User user) {
        User userToUpdate = userRepo.findById(id).
                orElseThrow(()-> new IllegalArgumentException("User with id " + id + " not found"));
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userRepo.save(userToUpdate);
    }

    public void changePassword(Long id, String password) {
        User userToUpdate = userRepo.findById(id).
                orElseThrow(()-> new IllegalArgumentException("User with id " + id + " not found"));
        userToUpdate.setPassword(password);
        userRepo.save(userToUpdate);
    }

}
