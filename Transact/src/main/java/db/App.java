package db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		Manager m =(Manager)context.getBean("man");
		User user=new User();
		user.setId(4);
		user.setUsername("sow");
		m.addUser(user);
		User user1=m.getUser(1);
		System.out.println(user1.getUsername());
	}

}
