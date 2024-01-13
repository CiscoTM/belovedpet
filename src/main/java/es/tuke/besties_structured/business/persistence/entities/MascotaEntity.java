package es.tuke.besties_structured.business.persistence.entities;

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

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity
@Table(name = "pets")
public class MascotaEntity {

    @Id
    @Column(name="pet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 28)
    private String nombre;

    @Column(name = "birth_date")
    private Timestamp fecha_nacimiento;

    // Relaciones
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    private TipoEntity tipo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<RazaMascotaEntity> razaMascota;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<PublicacionEntity> listaDePublicaciones;

    
}
