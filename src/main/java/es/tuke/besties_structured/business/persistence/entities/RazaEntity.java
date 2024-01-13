package es.tuke.besties_structured.business.persistence.entities;

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
@Table(name = "breeds")
public class RazaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="breed_id")
    private Long id;

    @Column(name="description")
    private String descripcion;

    @OneToMany(mappedBy = "raza", cascade = CascadeType.ALL)
    private List<RazaMascotaEntity> razaMascota;

    
}
