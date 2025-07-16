package com.tan.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tan.entities.Students;
import jakarta.persistence.Query;

public class StudentsList {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Students.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		Query q=ses.createQuery("from Students",Students.class);
		List<Students> list=q.getResultList();
		
		ses.close();
		System.out.println("Students data retrieved "+list.size());
		
		list.stream().forEach(obj->System.out.println(obj.getName()));
	}

}
