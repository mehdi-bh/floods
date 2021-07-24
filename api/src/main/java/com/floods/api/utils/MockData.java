package com.floods.api.utils;

import com.floods.api.entities.Publication;
import com.floods.api.entities.User;
import com.floods.api.enums.CategoryType;
import com.floods.api.enums.HelpType;
import com.floods.api.enums.PublicationType;
import com.floods.api.repositories.PublicationRepository;
import com.floods.api.repositories.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MockData {

    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    public MockData(UserRepository userRepository, PublicationRepository publicationRepository) {
        this.userRepository = userRepository;
        this.publicationRepository = publicationRepository;
    }

    @PostConstruct
    void init() {
        addData();
    }

    public void addData(){
        User mehdi = new User("mehdibhaddou@gmail.com","fdp");
        User yannick = new User("yannickv@gmail.com","aze");

        userRepository.save(mehdi);
        userRepository.save(yannick);

        Publication offer1 = new Publication(mehdi, PublicationType.OFFRE, HelpType.AIDES, CategoryType.MENAGE,"Aide ménagère","Bouillon","25/07/21","J'offre mon aide pour faire le ménage le 25",true,false);
        Publication offer2 = new Publication(mehdi, PublicationType.OFFRE, HelpType.AIDES, CategoryType.BATIMENT,"Maçon","Bouillon","26/07/21","Je peux construire un mur",false,false);
        Publication ask1 = new Publication(mehdi, PublicationType.DEMANDE, HelpType.BIENS, CategoryType.ELECTROMENAGER,"Machine à laver","Bouillon","25/07/21","J'ai besoin d'une machine à laver",true,false);

        Publication offer3 = new Publication(yannick, PublicationType.OFFRE, HelpType.BIENS, CategoryType.BATIMENT,"Briques à donner","Ransart","26/07/21","Je donne mes briques avec plaisir",false,false);
        Publication offer4 = new Publication(yannick, PublicationType.OFFRE, HelpType.AIDES, CategoryType.MENAGE,"Vaisselle","Ransart","26/07/21","Je fais la vaisselle comme personne",false,false);

        publicationRepository.save(offer1);
        publicationRepository.save(offer2);
        publicationRepository.save(offer3);
        publicationRepository.save(offer4);
        publicationRepository.save(ask1);
    }
}
