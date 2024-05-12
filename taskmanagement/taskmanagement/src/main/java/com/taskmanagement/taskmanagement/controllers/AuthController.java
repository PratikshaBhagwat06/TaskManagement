package com.taskmanagement.taskmanagement.controllers;




import java.util.Date;

import javax.crypto.SecretKey;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.taskmanagement.entities.User;
import com.taskmanagement.taskmanagement.repostories.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User loginUser) {

        // Retrieve user by email
        User user = userRepository.findByEmail(loginUser.getEmail());
//        String encodedPassword = encodePassword(loginUser.getPassword());
//
//        if (user == null || !user.getPassword().equals(encodedPassword)) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password");
//        }
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password");
        }
        

        // Compare encoded password
        if (!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email/password");
        }

        
        // Generate JWT token
        String jwtToken = generateToken(user);

        // Return the token to the client
        return ResponseEntity.ok(jwtToken);
    }
    
    public static String encodePassword(String password) {
		  return BCrypt.hashpw(password, BCrypt.gensalt());
	    }

    private static final long EXPIRATION_TIME = 900000000;//15 mins in ms 
    private static final String SECRET_KEY = "5DD8B4FFD7FAD4E3823B8DD640A3E99FB877840EE526B9200A7E018B61B816F5";
    private String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                   .setSubject(Long.toString(user.getId()))
                   .setIssuedAt(now)
                   .setExpiration(expiryDate)
                   .signWith(secretKey, SignatureAlgorithm.HS512)
                   .compact();
    }
    }


