package com.onuz;

import java.util.Date;

import org.hibernate.Session;

import com.onuz.entity.Person;
import com.onuz.entity.PersonDetail;
import com.onuz.util.HibernateUtil;

public class AppMain {
	public static void main(String[] args) {
		
		//Create database with src/sq/create_table.sql file
		System.out.println("Hibernate one to one (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Person np = new Person();

		np.setPersonName("Ali");
		np.setPersonSurname("Ahamada");
		
		PersonDetail npd = new PersonDetail();
		
		npd.setBirthPlace("Martigues");
		npd.setBirthDate(new Date(11-10-1991));
		npd.setCity("Toulouse");
		npd.setIdentityNo("notKnow");

		np.setPersonDetail(npd);
		npd.setPerson(np);
		
		session.save(np);
		session.getTransaction().commit();

		System.out.println("Done");
	}
}
