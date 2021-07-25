package com.floods.api.controllers;

import com.floods.api.entities.Publication;
import com.floods.api.entities.User;
import com.floods.api.entities.dtos.PublicationPostDTO;
import com.floods.api.entities.dtos.PublicationPutDTO;
import com.floods.api.entities.dtos.PublicationShortDTO;
import com.floods.api.enums.PublicationType;
import com.floods.api.repositories.PublicationRepository;
import com.floods.api.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
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
        return publication.orElse(null);
    }

    @GetMapping(PATH + "/offers")
    public List<Publication> getOffers(){
        return publicationRepository.findAllByPublicationType(PublicationType.OFFRE);
    }

    @GetMapping(PATH + "/asks")
    public List<Publication> getAsks(){
        return publicationRepository.findAllByPublicationType(PublicationType.DEMANDE);
    }

    @GetMapping(PATH + "/offers/short")
    public List<PublicationShortDTO> getOffersShort(){
        List<PublicationShortDTO> list = new ArrayList<>();
        getOffers().forEach(offer -> list.add(new PublicationShortDTO(offer.getId(),offer.getUser().getId(),offer.getPublicationType(),offer.getHelpType(),offer.getCategory(),offer.getTitle(),offer.getCity(),offer.getDate(),offer.isUrgent())));
        return list;
    }

    @GetMapping(PATH + "/asks/short")
    public List<PublicationShortDTO> getAsksShort(){
        List<PublicationShortDTO> list = new ArrayList<>();
        getAsks().forEach(ask -> list.add(new PublicationShortDTO(ask.getId(),ask.getUser().getId(),ask.getPublicationType(),ask.getHelpType(),ask.getCategory(),ask.getTitle(),ask.getCity(),ask.getDate(),ask.isUrgent())));
        return list;
    }

    @PostMapping(PATH)
    public Publication postPublication(@RequestBody PublicationPostDTO publicationPostDTO){
        User user = userRepository.findById(publicationPostDTO.getIdUser());
        Publication publication = new Publication(user,publicationPostDTO.getPublicationType(),publicationPostDTO.getHelpType(),publicationPostDTO.getCategory(),publicationPostDTO.getTitle(),publicationPostDTO.getCity(),publicationPostDTO.getDate(),publicationPostDTO.getDescription(),publicationPostDTO.isUrgent(),publicationPostDTO.isHidden());
        return publicationRepository.save(publication);
    }

    @PutMapping(PATH)
    public Publication putPublication(@RequestBody PublicationPutDTO publicationPutDTO){
        User user = userRepository.findById(publicationPutDTO.getIdUser());
        Publication publication = new Publication(publicationPutDTO.getId(),user,publicationPutDTO.getPublicationType(),publicationPutDTO.getHelpType(),publicationPutDTO.getCategory(),publicationPutDTO.getTitle(),publicationPutDTO.getCity(),publicationPutDTO.getDate(),publicationPutDTO.getDescription(),publicationPutDTO.isUrgent(),publicationPutDTO.isHidden());
        return publicationRepository.save(publication);
    }

    @DeleteMapping(PATH + "/{id}")
    public void deletePublication(@PathVariable Long id){
        publicationRepository.deleteById(id);
    }
}