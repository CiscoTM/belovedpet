package es.tuke.besties_structured.business.controllers;

import java.util.List;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.tuke.besties_structured.business.persistence.entities.UsuarioEntity;
import es.tuke.besties_structured.business.services.IUsuarioService;
import es.tuke.besties_structured.business.services.StorageService;
import es.tuke.besties_structured.business.services.dtos.UsuarioDTO;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    StorageService storage;



    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders = "*")
    @PostMapping("/saveUserAndImage")
    private ResponseEntity<UsuarioEntity> saveUserAndImage(@ModelAttribute UsuarioEntity user, BindingResult result, Model model, @RequestParam("file")MultipartFile file)throws IOException{

        model.addAttribute("user",user);

        if(!file.isEmpty()){
            String img = storage.store(file);
            user.setImgAvatar(img);

        }

        
        return new ResponseEntity<>(usuarioService.saveUser(user),HttpStatus.OK);

    }    


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
            .fecha_inscripcion(new SimpleDateFormat("dd MM yyyy h:m:s").format(new Date(usuario.getFecha_inscripcion().getTime())))
            .mascotas(usuario.getListaDeMascotas())
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
