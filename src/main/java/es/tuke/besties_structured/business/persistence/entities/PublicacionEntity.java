package es.tuke.besties_structured.business.persistence.entities;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity
@Table(name = "post")
public class PublicacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "publication_at")
    private Timestamp fecha_publicacion;

    @Column(name = "img")
    private String imagen;

    @Column(name = "text", length = 255)
    private String texto;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id",referencedColumnName = "member_id")
    private UsuarioEntity usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id",referencedColumnName = "pet_id")
    private MascotaEntity mascota;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<PreferenciaEntity> listaDepreferencias;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<ReporteEntity> listaDeReportes;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL)
    private List<ComentarioEntity> listaDeComentarios;
    
    
}
