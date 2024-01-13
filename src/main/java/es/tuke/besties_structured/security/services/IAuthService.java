package es.tuke.besties_structured.security.services;

import es.tuke.besties_structured.security.persistence.entities.UserEntity;
import es.tuke.besties_structured.security.services.models.dtos.LoginDTO;
import es.tuke.besties_structured.security.services.models.dtos.ResponseDTO;

public interface IAuthService {
    
    public ResponseDTO login(LoginDTO loginRequest) throws Exception;

    public ResponseDTO register(UserEntity user) throws Exception;
    
}
