package es.tuke.besties_structured.business.persistence.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import es.tuke.besties_structured.business.persistence.entities.TipoEntity;


public interface TipoRepository extends JpaRepository<TipoEntity, Long>{
    
}
