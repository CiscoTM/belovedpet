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
@Table(name = "report")
public class ReporteEntity {

    @Id
    @Column(name = "report_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id",referencedColumnName = "post_id")
    private PublicacionEntity publicacion;

   
    
}
