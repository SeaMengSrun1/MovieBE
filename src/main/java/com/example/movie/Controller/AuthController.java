package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.User;
import com.example.movie.Repository.UserRepo;
import com.example.movie.Request.AuthRequest;
import com.example.movie.Security.JwtUtil;
import com.example.movie.Service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
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


    @PostMapping("auth/signup")
    public ResponseDTO<Map<String, String>> signUp(@RequestBody AuthRequest authRequest) {
        try {
            User user = getUserService.signUp(authRequest);
            if (user != null) {
                final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
                User registeredUser = userRepository.findByEmail(authRequest.getEmail());
                Map<String, String> tokenMap = jwtUtil.generateToken(userDetails.getUsername(), registeredUser.getRole().toString());
                return new ResponseDTO<>("200", "Success", tokenMap);
            } else {
                return new ResponseDTO<>("400", "Failure", null);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseDTO<>("400", "Failure", null);
        } catch (Exception e) {
            return new ResponseDTO<>("400", "Failure", null);
        }
    }

    @PostMapping("auth/login")
    public ResponseDTO<Map<String, String>> login(@RequestBody User authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getPassword()
                    )
            );
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
        User user = userRepository.findByEmail(authRequest.getEmail());
        Map<String, String> tokenMap = jwtUtil.generateToken(userDetails.getUsername(), user.getRole().toString());
        return new ResponseDTO<>("200", "Success", tokenMap);
    }

    // @PostMapping("auth/login")
//    public ResponseDTO<Map<String, String>> login(@RequestBody User authRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authRequest.getEmail(),
//                            authRequest.getPassword()
//                    )
//            );
//        } catch (Exception e) {
//            System.out.println("Authentication failed: " + e.getMessage());
//            throw new Exception("Incorrect username or password", e);
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
//        return jwtUtil.generateToken(userDetails.getUsername());
//    }
    @PostMapping("auth/logout")
    public ResponseDTO<String> logout(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie", "token=; HttpOnly; Path=/; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:00 GMT");
        return new ResponseDTO<>("Success", "Logged out successfully", "200");
    }

    @GetMapping("/profile")
    public ResponseDTO<User> getProfile(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.extractUsername(token.substring(7));
        User user = userRepository.findByEmail(username);
        return new ResponseDTO<>("200", "Success", user);
    }

    public Map<String, String> generateToken(String username, String role) {
        String token = Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours expiration
                .signWith(SignatureAlgorithm.HS256, "secret_key") // Use a secure key
                .compact();

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("role", role);
        return tokenMap;
    }
}
