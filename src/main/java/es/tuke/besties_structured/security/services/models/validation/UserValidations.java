package es.tuke.besties_structured.security.services.models.validation;

import es.tuke.besties_structured.security.persistence.entities.UserEntity;
import es.tuke.besties_structured.security.services.models.dtos.ResponseDTO;

public class UserValidations {
    
    public ResponseDTO validate(UserEntity user) {

        ResponseDTO response = ResponseDTO.builder()
        .numOfErrors(0)
        .build();

        if (user.getFirstName() == null || user.getFirstName().length() < 3 || user.getFirstName().length() > 15) {

        response.setNumOfErrors(response.getNumOfErrors()+1);
        response.setMessage("El campo nombre no puede ser nulo, menor de 3 caracteres o mayor de 15");
        }

        if (user.getLastName() == null || user.getLastName().length() < 3 || user.getLastName().length() > 15) {

        response.setNumOfErrors(response.getNumOfErrors()+1);
        response.setMessage("El campo apellido no puede ser nulo, menor de 3 caracteres o mayor de 30");
        }

        if(user.getEmail() == null || !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){

            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("El campo email no es valido");

        }

        if(user.getPassword() == null || !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")){

            response.setNumOfErrors(response.getNumOfErrors()+1);
            response.setMessage("La contraseña debe tener entre 8 y 16 caracteres al menos un número, una minúscula y una mayúscula");

        }

        return response;
    }
}
