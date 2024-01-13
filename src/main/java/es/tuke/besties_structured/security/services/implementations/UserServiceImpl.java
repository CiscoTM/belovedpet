package es.tuke.besties_structured.security.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.tuke.besties_structured.security.persistence.entities.UserEntity;
import es.tuke.besties_structured.security.persistence.repositories.UserRepository;
import es.tuke.besties_structured.security.services.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository repository;


    @Override
    public List<UserEntity> finAllUsers() {

        return repository.findAll();
        
    }

}
