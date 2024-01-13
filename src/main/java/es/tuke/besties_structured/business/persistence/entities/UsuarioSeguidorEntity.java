package es.tuke.besties_structured.business.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity
@Table(name = "followers_user")
public class UsuarioSeguidorEntity {

    @Id
    @Column(name = "followerUser_id")
    private Long id;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private UsuarioEntity usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "follower_id", referencedColumnName = "follower_id")
    private SeguidorEntity seguidor;
    
}
