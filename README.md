# Spring Core Application without MVC and Web dependency
Spring Dependency Injection and Spring IoC container.

At the heart of Spring framework is the spring container. We have two types of containers in spring :  `BeanFactory` and `ApplicationContexts`.
The container is responsible for managing the lifecycle of each bean from instantiation to finalize.
`BeanFactory` is the low level container. It is the simplest of container type defined by `org.springframework.beans.factory.BeanFactory`.

ApplicationContexts - There are several types of application contexts defined by `org.springframework.context.ApplicationContext`. Spring container is responsible for wiring the dependent beans together.
Following are the ApplicationContexts available:
* `AnnotationConfigApplicationContext`
* `AnnotationConfigWebApplicationContext`
* `ClasspathXMLApplicationContext`
* `FileSystemXMLApplicationContext`

You can create a spring application with only spring core support by adding following dependency in the 
`pom.xml` file.

```
<dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.9</version>
 </dependency>
```
With the above dependency maven will bring the following libraries into the project transitively.
```
    org.springframework:spring-context
    org.springframework:spring-aop
    org.springframework:spring-beans
    org.springframework:spring-core
    org.springframework:spring-expression
    org.springframework:spring-jcl
    
```
The above libraries will provide support Dependency Injection and IoC by wiring or autowiring of beans.

After adding the dependency in pom.xml file add main application class in the project which will have 
`public static void main()` method. In the main method first instantiate Spring Application Context with 
the configuration file which will have all the bean definitions. We will use Java annotations for 
configuration and not xml.

`Application.java`
```
public class Application {
 public static void main(String [] args){

        ApplicationContext springAppContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
     
        }
     }
```


`ApplicationConfiguration.java`

```
@Configuration
public class ApplicationConfiguration {

    @Bean(name = "userService")
    public UserService getUserService(){
    
        UserServiceImpl userService = new UserServiceImpl(getUserRepository()); //use constructor injection
//        userService.setRepository(getUserRepository());   //or use setter injection
        return userService;
        
    }

    @Bean(name = "userRepository")
    public UserRepository getUserRepository(){
        return new UserRepositoryImpl();
    }
}
```

After all the beans have been defined now it should be possible to get these beans in the main method from 
spring application context.

`Application.java`
```
public class Application {
 public static void main(String [] args){

        ApplicationContext springAppContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserService userService = springAppContext.getBean("userService", UserService.class);
        
        //it should be possible to ask spring context for all the beans as well
        String[] beans = springAppContext.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println("Bean Name: "+ bean);
        
        }
     }
```
### Auto Configuration
The beans can also be auto configured by spring context thereby eliminating the need to define all the 
beans in a single configuration class like `ApplicationConfiguration`.
To enable auto configuration all we need to do is enable autoscanning of beans in the 
`ApplicationConfiguration` class by annotating it with `@ComponentScan` and specifying the root package.

```
@Configuration
@ComponentScan("com.dk")// Needed to enable discovery of other beans in the package hierarchy. Otherwise 
                        //only those beans will be instantiated which are in this class
public class ApplicationConfiguration {

//No need to define beans here
    }
}
```

And the second step would be to annotate respective classes with spring stereotype annotations like 
`@Component`, `@Repository`,`@Service` etc.

```

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository repository ; //the User repository object will be auto wired by spring after 
                                        //discovering it
    
    
    //constructor injection
    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    
    //setter injection
    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll(){
        return repository.findAll();
    }

}


```

```

@Repository("userRepository")
public class UserRepositoryImpl implements com.dk.repository.UserRepository {

    @Override
    public List<User> findAll(){

        List<User> userList = new ArrayList<User>();

        User user1 = new User("Test", "User1",1111);
        userList.add(user1);
        return userList;
    }
}
```
By default the scope of beans is SINGLETON. It should be possible to have beans with scope of PROTOTYPE 
wherein a new bean instance will be created by spring for each request before returning the bean.

There are three more scopes for beans which are valid only in Web applications.
* REQUEST
* SESSION
* GLOBAL SESSION

Always use the constants defined in ConfigurableBeanFactory to specify bean scopes instead of direct 
string values e.g.:  ConfigurableBeanFactory.SCOPE_PROTOTYPE.
