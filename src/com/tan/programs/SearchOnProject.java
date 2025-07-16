package com.tan.programs;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tan.entities.Students;
import jakarta.persistence.Query;

public class SearchOnProject {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Students.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Project Topic : ");
		String ty=sc.nextLine();
		
		Query q=ses.createQuery("from Students where projecttopic= :projecttopic",Students.class);
		q.setParameter("projecttopic", ty);
		List<Students> list=q.getResultList();
		
		System.out.println("Students list "+list.size());
		list.stream().forEach(obj->System.out.println(obj.getName()));
		
		ses.close();
		sc.close();
	}

}
