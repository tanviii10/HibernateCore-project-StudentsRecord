package com.tan.programs;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tan.entities.Students;
import jakarta.persistence.Query;

public class SearchOnEnrollNo {
	public static void main(String[] args) {
		
		String enrollno;
		Scanner sc=new Scanner(System.in);
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Students.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		Query q=ses.createQuery("from Students where enrollmentno= :enrollmentno",Students.class);
		
		System.out.print("Enter enrollment number : ");
		enrollno=sc.nextLine();
		
		q.setParameter("enrollmentno", enrollno);
		List<Students> list=q.getResultList();
		
		System.out.println("Students Retrieved : "+list.size());
		
		list.stream().forEach(obj->System.out.println(obj.getEnrollmentno()+"->"+obj.getName()));
		sc.close();
		
	}

}
