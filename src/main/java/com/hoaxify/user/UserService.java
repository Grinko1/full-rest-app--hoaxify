package com.hoaxify.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   private final UserRepository userRepository;
   BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();






    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
    }

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }
}
