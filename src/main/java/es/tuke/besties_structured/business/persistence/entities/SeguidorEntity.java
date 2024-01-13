package es.tuke.besties_structured.business.persistence.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity
@Table(name = "followers")
public class SeguidorEntity {

    @Id
    @Column(name = "follower_id")
    private Long id; 
    
    

    @OneToMany(mappedBy = "seguidor", cascade = CascadeType.ALL)
    private List<UsuarioSeguidorEntity> listaDeUsuariosSeguidores;

    

}
