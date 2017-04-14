package main.java.com.veena.hello.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.veena.hello.dvo.Actor;






public class HelloWorld {


		
		 public static void main(String[] args) {
			 
			 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		     Greeter greeter = (Greeter)ctx.getBean("greeterClass");
		     SessionFactory sessionfact= new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		    Session sf= sessionfact.openSession();
		     sf.beginTransaction();
		     Actor actor=new Actor();
		     actor.setFirst_name("Test");
		     actor.setLast_name("User");
		     sf.persist(actor);
		     System.out.println("a");
		     sf.getTransaction().commit();
		     sf.close();
		    }
		
	}

