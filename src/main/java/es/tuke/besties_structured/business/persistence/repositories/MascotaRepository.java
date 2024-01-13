package es.tuke.besties_structured.business.persistence.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import es.tuke.besties_structured.business.persistence.entities.MascotaEntity;


public interface MascotaRepository extends JpaRepository<MascotaEntity, Long> {
    
}
