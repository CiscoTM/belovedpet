package es.tuke.besties_structured.business.controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.tuke.besties_structured.business.persistence.entities.UsuarioEntity;
import es.tuke.besties_structured.business.services.IUsuarioService;
import es.tuke.besties_structured.business.services.dtos.UsuarioDTO;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;


    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders = "*")
    @PostMapping("/save")
    private ResponseEntity<UsuarioEntity> saveUser(@RequestBody UsuarioEntity user){
        
        return new ResponseEntity<>(usuarioService.saveUser(user),HttpStatus.OK);

    }    


    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders = "*")
    @GetMapping("/findAll")
    private ResponseEntity<List<UsuarioDTO>> getAllUser() {

        List<UsuarioEntity> lista = usuarioService.findAllEmployeers();

        List<UsuarioDTO> listaDTO = new ArrayList<UsuarioDTO>();

        for(UsuarioEntity usuario: lista){

            UsuarioDTO e = UsuarioDTO.builder()
            .nombre(usuario.getNombre())
            .build();

            listaDTO.add(e);

        }

        return new ResponseEntity<>(listaDTO, HttpStatus.OK); 
    }

    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders = "*")
    @GetMapping("/pageable/findAll")
    private ResponseEntity<Page<UsuarioEntity>> getAllUserPageable(Pageable pageable) {

        Page<UsuarioEntity> lista = usuarioService.findAllEmployeersPageable();

        List<UsuarioDTO> listaDTO = new ArrayList<UsuarioDTO>();

        for(UsuarioEntity usuario: lista){

            UsuarioDTO e = UsuarioDTO.builder()
            .nombre(usuario.getNombre())
            .build();
            
            listaDTO.add(e);

        }

        return new ResponseEntity<>(lista, HttpStatus.OK); 
    }
    
}
