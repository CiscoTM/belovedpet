package es.tuke.besties_structured.business.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.tuke.besties_structured.business.persistence.entities.PublicacionEntity;


public interface PublicacionRepository extends JpaRepository<PublicacionEntity, Long> {
    
}
