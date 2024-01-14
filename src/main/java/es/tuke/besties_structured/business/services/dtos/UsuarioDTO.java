package es.tuke.besties_structured.business.services.dtos;


import java.util.List;

import es.tuke.besties_structured.business.persistence.entities.MascotaEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder @Getter @Setter
public class UsuarioDTO {

    private String nombre;
    private String fecha_inscripcion;

    private List<MascotaEntity> mascotas;

        
}
