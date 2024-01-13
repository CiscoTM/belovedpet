package es.tuke.besties_structured.business.persistence.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class PreferenciaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id",referencedColumnName = "post_id")
    private PublicacionEntity publicacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id",referencedColumnName = "member_id")
    private UsuarioEntity usuario;





}
