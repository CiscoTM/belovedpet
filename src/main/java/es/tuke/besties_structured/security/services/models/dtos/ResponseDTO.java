package es.tuke.besties_structured.security.services.models.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder @Getter @Setter
public class ResponseDTO {

    private int numOfErrors;
    private String message;
    private String jwt;

    
}
