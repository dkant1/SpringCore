package com.dk;

import com.dk.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String [] args){

        ApplicationContext springAppContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UserService userService = springAppContext.getBean("userService", UserService.class);
        //UserService userService = new UserServiceImpl();

        System.out.println("User Name is: " + userService.getAll().get(0).getFirstName());

        String[] beans = springAppContext.getBeanDefinitionNames();//get all the bean names

        System.out.println("----------Printing all beans from context---------------");
        for (String bean : beans) {
            System.out.println("Bean Name: "+ bean);
        }


    }
}
