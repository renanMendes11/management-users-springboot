package com.renan.managementusersbackend.controllers;

import com.renan.managementusersbackend.models.User;
import com.renan.managementusersbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    private List<User> index(){
        return this.userRepository.findAll();
    }

    @PostMapping("")
    private User store(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @GetMapping("/{id}")
    private Optional<User> show(@PathVariable("id") Long id){
        return this.userRepository.findById(id);
    }

    @PutMapping("/{id}")
    private void update(@RequestBody User user, @PathVariable("id") Long id){
        this.userRepository.update(user, id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") Long id){
        this.userRepository.deleteById(id);
    }

}
