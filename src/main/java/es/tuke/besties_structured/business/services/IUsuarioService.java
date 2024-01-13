package es.tuke.besties_structured.business.services;

import java.util.List;

import org.springframework.data.domain.Page;

import es.tuke.besties_structured.business.persistence.entities.UsuarioEntity;

public interface IUsuarioService {
    
    public List<UsuarioEntity>findAllEmployeers();
    public Page<UsuarioEntity>findAllEmployeersPageable();
    public UsuarioEntity saveUser(UsuarioEntity usuario);
}
