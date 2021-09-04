package com.dk;

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


