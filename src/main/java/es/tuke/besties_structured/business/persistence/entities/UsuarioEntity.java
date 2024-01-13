package es.tuke.besties_structured.business.persistence.entities;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity
@Table(name = "members")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "alias")
    private String nombre;

    @Column(name = "from_date")
    private Timestamp fecha_inscripcion;

    @Column(name = "img_avatar")
    private String imgAvatar;



    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<MascotaEntity> listaDeMascotas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<PublicacionEntity> listaDepublicaciones;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<UsuarioSeguidorEntity> listaDeUsuariosSeguidores;

    
}
