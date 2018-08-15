package com.offon.unitile;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offon.pojo.Book;
import com.offon.pojo.User;

public class App {
	@Test
	public void action6(){
		
		ApplicationContext s=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Book b=(Book)s.getBean("book");
		System.out.println(b.getName());
		
	}
	@Test
	public void action7(){
		ApplicationContext s=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Book r=(Book)s.getBean("book");
		r.acy();
		
	}
	@Test
	public void aci(){
		ApplicationContext s=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		
		
		}
	
}
