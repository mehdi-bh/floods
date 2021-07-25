package com.floods.api.repositories;

import com.floods.api.entities.Publication;

import com.floods.api.enums.PublicationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>{
    List<Publication> findAllByPublicationType(PublicationType type);
}
