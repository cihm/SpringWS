package com.cihm.controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cihm.pojo.Person;
import com.cihm.util.HibernateUtil;

@RestController
@RequestMapping(value = "/hibernate")

public class HibernateController {

	
	// Post method
	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	public Person testPost(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			@RequestParam(value = "age", required = false, defaultValue = "World") int age) {

		 System.out.print("i m  in :" + age+name);
		
		 Person person = new Person(age, name);
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 session.beginTransaction();
		 session.save(person);
		 session.getTransaction().commit();
		 session.close();
		 
		return person;
	}

}
