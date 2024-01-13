package es.tuke.besties_structured.security.controllers;

import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.tuke.besties_structured.security.persistence.entities.UserEntity;
import es.tuke.besties_structured.security.services.IAuthService;
import es.tuke.besties_structured.security.services.models.dtos.LoginDTO;
import es.tuke.besties_structured.security.services.models.dtos.ResponseDTO;

@RestController
@RequestMapping("/auth")
public class AuthControllers {

     @Autowired
    IAuthService authService; 
    
    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders = "*")
    @PostMapping("/register")
    private ResponseEntity<ResponseDTO> register(@RequestBody UserEntity user) throws Exception{
        return new ResponseEntity<>(authService.register(user),HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders = "*")
    @PostMapping("/login")
    private ResponseEntity<ResponseDTO> login(@RequestBody LoginDTO loginRequest) throws Exception{
        
        ResponseDTO login = authService.login(loginRequest);
        
        if(!login.getJwt().isEmpty()){

            return ResponseEntity.ok()
            .header(HttpHeaders.AUTHORIZATION,login.getJwt())
            .build();
        
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        }

     
    }

   
    
}


