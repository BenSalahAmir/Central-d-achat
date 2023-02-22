package tn.esprit.pidev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.esprit.pidev.Service.IUserServiceImp;

@SpringBootApplication
public class PidevApplication {

    public static void main(String[] args) {
        SpringApplication.run(PidevApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner run(IUserServiceImp userService) {
        return args -> {
            userService.addRoleToUser("amir.bensalah@esprit.tn","ROLE_ACHETEUR");
        };
   }
   */

}
