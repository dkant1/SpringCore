package com.dk;

import com.dk.repository.UserRepository;
import com.dk.repository.UserRepositoryImpl;
import com.dk.service.UserService;
import com.dk.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dk")
public class ApplicationConfiguration {

//    @Bean(name = "userService")
//    public UserService getUserService(){
//        UserServiceImpl userService = new UserServiceImpl(getUserRepository());
////        userService.setRepository(getUserRepository());
//        return userService;
//    }
//
//    @Bean(name = "userRepository")
//    public UserRepository getUserRepository(){
//        return new UserRepositoryImpl();
//    }
}


