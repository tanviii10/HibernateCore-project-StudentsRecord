package com.tan.programs;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tan.entities.Students;

public class NewStudent {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int rno;
		String nm,enrollno,topic;
		
		System.out.print("Enter roll no:");
		rno=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter name:");
		nm=sc.nextLine();
		System.out.print("Enter enrollment number:");
		enrollno=sc.nextLine();
		System.out.print("Enter project topic:");
		topic=sc.nextLine();
		
		Students s=new Students();
		s.setRollno(rno);
		s.setName(nm);
		s.setEnrollmentno(enrollno);
		s.setProjecttopic(topic);
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Students.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		ses.persist(s);
		ses.getTransaction().commit();
		System.out.println("new Student added successfully");
		ses.close();
		sc.close();
		
		
	}

}
