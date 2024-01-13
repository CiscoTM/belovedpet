package es.tuke.besties_structured.security.config;

import es.tuke.besties_structured.security.services.models.validation.UserValidations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationsConfig {
    
    @Bean
    public UserValidations userValidations(){
        return new UserValidations();
    }
}
    

