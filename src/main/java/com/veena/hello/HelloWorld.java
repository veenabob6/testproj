package com.veena.hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.veena.hello.Actor;
import com.veena.hello.Greeter;

public class HelloWorld {


		
		 public static void main(String[] args) {
			 
			 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		     Greeter greeter = (Greeter)ctx.getBean("greeterClass");
		     SessionFactory sessionfact= new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();
		    Session sf= sessionfact.openSession();
		     sf.beginTransaction();
		     Actor actor=new Actor();
		     actor.setFirst_name("Veena1");
		     actor.setLast_name("Nair");
		     sf.persist(actor);
		     System.out.println("Hakunamatata");
		     sf.getTransaction().commit();
		     sf.close();
		    }
		
	}

