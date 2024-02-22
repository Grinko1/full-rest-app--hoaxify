package com.hoaxify.user;

import com.hoaxify.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public GenericResponse createUser(@RequestBody User user){
        userService.save(user);
        return new GenericResponse("User saved");

    }
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
