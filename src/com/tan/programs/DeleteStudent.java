package com.tan.programs;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tan.entities.Students;

public class DeleteStudent {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.addAnnotatedClass(Students.class).buildSessionFactory();
		Session ses=sf.getCurrentSession();
		ses.beginTransaction();
		
		int no;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Roll number : ");
		no=sc.nextInt();
		
		Query q=ses.createQuery("delete from Students where rollno=:rno");
		q.setParameter("rno", no);
		int cnt=q.executeUpdate();
		ses.getTransaction().commit();
		System.out.println("records deleted : "+cnt);
	}

}
