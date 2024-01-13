package es.tuke.besties_structured.business.persistence.entities;

import java.sql.Timestamp;

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



@AllArgsConstructor @Data @Builder
@Entity
@Table(name = "comment")
public class ComentarioEntity {
 
    public ComentarioEntity() {
        
        Long datetime = System.currentTimeMillis();
        this.fecha_inscripcion = new Timestamp(datetime);

    }


    @Id
    @Column(name = "comment_id")
    private Long id;
    
    @Column(name = "text", length = 255)
    private String texto;
    
    @Column(name = "from_date")
    private Timestamp fecha_inscripcion;


    // Relaciones
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id",referencedColumnName = "post_id")
    private PublicacionEntity publicacion;



}
