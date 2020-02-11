package hello;


import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hello.beans.MyBean1;
import hello.beans.Sorter;

public class MainApp {


	public static void main(String[] args) {
			
//		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml")){
		
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()){
		ctx.register(AppContextConfig.class);
//		ctx.register(MyBean1.class);// you can also register a bean directly with the context
		ctx.refresh();
		
		
		String[] beans = ctx.getBeanDefinitionNames();//get all the bean names
		
		System.out.println("----------Printing all beans from context---------------");
		for (String bean : beans) {
			System.out.println("Bean Name: "+ bean);			
		}
		
		System.out.println("------------------------------------");
		
		HelloMessage msg = (HelloMessage) ctx.getBean("helloMessage");//ask Spring Context for bean named helloMessage
		System.out.println("HelloMessage Bean: " + msg);
		msg.printMessage();// call a method on the helloMessage bean
		
		MyBean1 myBean1 = (MyBean1) ctx.getBean("myBean1");
		System.out.println("MyBean1 Bean: " + myBean1);
		myBean1.printBeanMessage();//This should print the string from HelloMessage method
		
		
		int[] intArr = new int[] {9,5,8,6,4,1,7,3,2,0};
		

		Sorter sorter = (Sorter) ctx.getBean("sorter");
	
		sorter.sort(intArr);
		
		
		
		
		
		
		
		
	}
	}

}
