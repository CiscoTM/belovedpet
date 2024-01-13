package es.tuke.besties_structured.security.services;

import es.tuke.besties_structured.security.persistence.entities.UserEntity;
import java.util.List;

public interface IUserService {
    
    public List<UserEntity> finAllUsers();

}
