package hello;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "hello") //if this is not specified then no other bean will be registered except the ones defined below in this file
public class AppContextConfig {
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public HelloMessage helloMessage() {
		return new HelloMessage();
	}
	


}
