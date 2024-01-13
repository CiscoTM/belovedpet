package es.tuke.besties_structured.security.services.implementations;

import es.tuke.besties_structured.security.persistence.entities.UserEntity;
import es.tuke.besties_structured.security.persistence.repositories.UserRepository;
import es.tuke.besties_structured.security.services.IAuthService;
import es.tuke.besties_structured.security.services.IJWTUtilityService;
import es.tuke.besties_structured.security.services.models.dtos.LoginDTO;
import es.tuke.besties_structured.security.services.models.dtos.ResponseDTO;
import es.tuke.besties_structured.security.services.models.validation.UserValidations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthServiceImpl implements IAuthService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private IJWTUtilityService jwtUtilityService;

    @Autowired
    private UserValidations validations;

    @Override
    public ResponseDTO login(LoginDTO loginRequest) throws Exception {
               
        try {

            ResponseDTO responseDTO = ResponseDTO.builder().build();
            Optional<UserEntity> user = repository.findByEmail(loginRequest.getEmail());

            if (user.isEmpty()) {

                responseDTO.setMessage("user already exists");
                responseDTO.setNumOfErrors(responseDTO.getNumOfErrors());             
                return responseDTO;
            }
            if (verifyPassword(loginRequest.getPassword(), user.get().getPassword())) {

                responseDTO.setMessage("user logged correctly");
                responseDTO.setNumOfErrors(0);
                responseDTO.setJwt(jwtUtilityService.generateJWT(user.get().getFirstName()));

            } else {
                responseDTO.setMessage("Authentication failed");
                responseDTO.setNumOfErrors(responseDTO.getNumOfErrors());  
            }
            return responseDTO;


        } catch (IllegalArgumentException e) {
            System.err.println("Error generating JWT: " + e.getMessage());
            throw new Exception("Error generating JWT", e);
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.toString());
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    public ResponseDTO register(UserEntity user) throws Exception{

        try {

            ResponseDTO response = validations.validate(user);

            if(response.getNumOfErrors() > 0){
                return response;
            }


            List<UserEntity> getAllUsers = repository.findAll();

            for(UserEntity repeat : getAllUsers){
                if(repeat.getEmail().equals(user.getEmail())){
                    response.setNumOfErrors(1);
                    response.setMessage("User already exits!");
                    return response;
                }
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));

            repository.save(user);
            response.setMessage("User created succesfully!");

            return response;
            
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }


    private boolean verifyPassword(String enteredPassword, String storedPassword){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);

    }



    
}
