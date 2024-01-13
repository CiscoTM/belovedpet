package es.tuke.besties_structured.business.services.implementations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

import es.tuke.besties_structured.business.persistence.entities.UsuarioEntity;
import es.tuke.besties_structured.business.persistence.repositories.UsuarioRepository;
import es.tuke.besties_structured.business.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    UsuarioRepository repository;

    @Autowired
    FileSystemStorageService storageService;


    @Override
    public List<UsuarioEntity> findAllEmployeers() {
        return repository.findAll();
    }

    @Override
    public Page<UsuarioEntity> findAllEmployeersPageable() {

        final Pageable pageable = PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC,"nombre"));

        return repository.findAll(pageable);
    }

    @Override
    public UsuarioEntity saveUser(UsuarioEntity usuario){


        Long datetime = System.currentTimeMillis();
        usuario.setFecha_inscripcion(new Timestamp(datetime));

        return repository.save(usuario);
    }
       

}
