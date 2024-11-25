package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.User;
import com.example.movie.ModelDTO.MovieDTO;
import com.example.movie.Repository.UserRepo;
import com.example.movie.Security.JwtUtil;
import com.example.movie.Service.CustomUserDetailsService;
import com.example.movie.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService getUserService;




    @PostMapping("/authenticate")
    public ResponseDTO<Map<String, String>> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setEmail(authRequest.getEmail());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setRole(User.Role.USER); // Default role
        userRepository.save(user);
        if (userRepository.findByUsername(authRequest.getUsername()) != null) {
            return "User created successfully";
        } else {
            return "User creation failed";
        }
    }
    private void orElseThrow(Object userCreationFailed) {
    }

    @PostMapping("/login")
    public ResponseDTO<Map<String, String>> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());  // Log the error
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @GetMapping("/users")
    public ResponseDTO<List<User>> getUser() {
        return new ResponseDTO<>("200", "Success", getUserService.getUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseDTO<User> getUserById(@PathVariable Long id) {
        return new ResponseDTO<>("200", "Success", getUserService.getUserById(id));
    }

    @GetMapping("/users/username/{username}")
    public ResponseDTO<User> getUserByUsername(@PathVariable String username) {
        return new ResponseDTO<>("200", "Success", getUserService.getUserByUsername(username));
    }

    @GetMapping("/users/email/{email}")
    public ResponseDTO<User> getUserByEmail(@PathVariable String email) {
        return new ResponseDTO<>("200", "Success", getUserService.getUserByEmail(email));
    }

    @DeleteMapping("/users/{id}")
    public ResponseDTO<String> deleteUser(@PathVariable Long id) {
        getUserService.deleteUser(id);
        return new ResponseDTO<>("200", "User deleted successfully", null);
    }

    @PutMapping("/users/{id}")
    public ResponseDTO<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        getUserService.updateUser(id, user);
        return new ResponseDTO<>("200", "User updated successfully", null);
    }

    @PutMapping("/users/{id}/changePassword")
    public ResponseDTO<String> changePassword(@PathVariable Long id, @RequestBody String password) {
        getUserService.changePassword(id, password);
        return new ResponseDTO<>("200", "Password changed successfully", null);
    }

}
