package com.floods.api.controllers;

import com.floods.api.entities.User;
import com.floods.api.repositories.PublicationRepository;
import com.floods.api.repositories.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        return user.orElse(null);
    }
}
