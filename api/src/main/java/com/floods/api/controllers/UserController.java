package com.floods.api.controllers;

import com.floods.api.entities.User;
import com.floods.api.entities.dtos.UserNewAccountDTO;
import com.floods.api.repositories.PublicationRepository;
import com.floods.api.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
public class UserController {

    private final String PATH = "/users";

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    public UserController(UserRepository userRepository, PublicationRepository publicationRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
    }

    @GetMapping(PATH + "/{id}")
    public User getUser(@PathVariable Long id){
        Optional<User> user;
        user = userRepository.findById(id);
        if (user.isPresent()){
            return user.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"L'ID n'existe pas");
        }
    }

    @GetMapping(PATH)
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping(PATH + "/auth")
    public User login(@RequestBody UserNewAccountDTO userNewAccountDTO){
        User user = userRepository.findByEmail(userNewAccountDTO.getEmail());
        if (user != null && user.getPassword().equals(userNewAccountDTO.getPassword())){
            return user;
        }
        else{
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Logins invalides");
        }
    }

    @PostMapping(PATH)
    public User postUser(@RequestBody UserNewAccountDTO userNewAccountDTO){
        User user = new User(userNewAccountDTO.getEmail(),userNewAccountDTO.getPassword());
        return userRepository.save(user);
    }

    @PutMapping(PATH)
    public User putUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping(PATH + "/{id}")
    public void deleteUser(@PathVariable Long id){
        User user = getUser(id);
        userRepository.delete(user);
    }
}
