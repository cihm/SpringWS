package com.cihm.controller;
import org.hibernate.Session;

import com.cihm.pojo.Person;
import com.cihm.util.HibernateUtil;
public class testHibernate {
  public static void main(String[] args) {
	 Person person = new Person(11,"46");
	 person.setId(1);
	 person.setName("Concretepage");
	 Session session = HibernateUtil.getSessionFactory().openSession();
	 session.beginTransaction();
	 session.save(person);
	 session.getTransaction().commit();
	 session.close();
	 System.err.println("Done");
  }
} 