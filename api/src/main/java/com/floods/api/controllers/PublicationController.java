package com.floods.api.controllers;

import com.floods.api.entities.Publication;
import com.floods.api.entities.User;
import com.floods.api.repositories.PublicationRepository;
import com.floods.api.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PublicationController {

    private final String PATH = "/publications";

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    public PublicationController(UserRepository userRepository, PublicationRepository publicationRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
    }

    @GetMapping(PATH + "/{id}")
    public Publication getPublication(@PathVariable Long id){
        Optional<Publication> publication;
        publication = publicationRepository.findById(id);
        System.out.println();
        return publication.orElse(null);
    }
}
