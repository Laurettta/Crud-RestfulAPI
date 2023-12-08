package com.Lauretta.app.rest.controller;

import com.Lauretta.app.rest.controller.model.User;
import com.Lauretta.app.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/save")
    public String saveUser (@RequestBody User user){
        userRepository.save(user);
        return "Saved..";
    }

    @PutMapping("update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updateUser = userRepository.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setOccupation(user.getOccupation());
        updateUser.setAge(user.getAge());
        userRepository.save(updateUser);
        return "Updated..";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser (@PathVariable long id){
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "Delete user with the id: "+id;
    }

}



