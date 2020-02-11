package hello.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.HelloMessage;

@Component
public class MyBean1 {
	
	private HelloMessage msg1;

	public HelloMessage getMsg1() {
		return msg1;
	}

	@Autowired
	public void setMsg1(HelloMessage msg1) {
		this.msg1 = msg1;
	}
	
	public void printBeanMessage() {
		System.out.println("Message printed from MyBean1: " + this.msg1);
		 this.msg1.printMessage();
		 
		 Thread th1 = new Thread( ()->{
			 
			 for(int i=0; i<20; i++)
//				 System.out.println("Message from inside thread1");
				 ;
			 
		 }
		 );
			
		 Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<20; i++)
//					System.out.println("Message from inside thread2");
					;
				
			}
		});
		 
		 
		 th1.start();
		 th2.start();
	}

}
