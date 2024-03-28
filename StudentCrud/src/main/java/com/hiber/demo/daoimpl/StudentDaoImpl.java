package com.hiber.demo.daoimpl;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hiber.demo.config.HiberUtil;
import com.hiber.demo.dao.StudentDao;
import com.hiber.demo.entity.Student;

public  class StudentDaoImpl implements StudentDao
{
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void addStd()
	{
		Session session = HiberUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		int stdid;
		String stdname, stdsurname,dob, stdgender, stdemail;
		long stdphone;
		
		System.out.println("Enter the Id");
		stdid =sc.nextInt();
		
		System.out.println("Enter the First Name");
		stdname=sc.next();
		
		System.out.println("Enter the Surname");
		stdsurname=sc.next();
		
		System.out.println("Enter the DOB");
		dob=sc.next();
		
		System.out.println("Enter the Gender");
		stdgender=sc.next();
		
		System.out.println("Enter the Email ID");
		stdemail=sc.next();
		
		System.out.println("Enter the Phone Number");
		stdphone=sc.nextLong();
		
		Student std = new Student();
		std.setStdid(stdid);
		std.setStdname(stdname);
		std.setStdsurname(stdsurname);
		std.setDob(dob);
		std.setStdgender(stdgender);
		std.setStdemail(stdemail);
		std.setStdphone(stdphone);
		
		session.save(std);
		tx.commit();
		session.close();
		
		System.out.println("Student Data Added Successfully");
		
	}
	
	@Override
	public void deleteStd() 
	{
		Session session = HiberUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		int stdid;
		String stdname, stdsurname, dob, stdgender, stdemail;
		long stdphone;
		
		System.out.println("Enter the Id");
		stdid = sc.nextInt();
		
		Student std = session.get(Student.class, stdid);
		std.setStdid(stdid);
		session.delete(std);
		tx.commit();
		session.close();
		
		System.out.println("Student Data Deleted Successfully");
		
	}
	
	@Override
	public void editStd() 
	{
		Session session = HiberUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		int stdid;
		String stdname, stdsurname, stdgender, stdemail;
		String dob;
		long stdphone;
		
		System.out.println("Enter the Id");
		stdid=sc.nextInt();
		
		Student std = session.get(Student.class, stdid);
		if (std != null)
		{
			// Allow the user to modify employee information
			System.out.println("Enter the Name");
			stdname=sc.next();
			std.setStdname(stdname);
					    
			System.out.println("Enter the Surname");
			stdsurname = sc.next();
			std.setStdsurname(stdsurname);
				       
			System.out.println("Enter the Date of Birth");
			dob = sc.next();
			std.setDob(dob);
				        
			System.out.println("Enter the Gender");
			stdgender = sc.next();
			std.setStdgender(stdgender);
			
			System.out.println("Enter the Email Id");
			stdemail = sc.next();
			std.setStdemail(stdemail);
			
			System.out.println("Enter the Phone No.");
			stdphone = sc.nextLong();
			std.setStdphone(stdphone);
			
			session.update(std);
			tx.commit();
						
			System.out.println("Student data Updated Successfully");
			
		}
		session.close();
					
	}
	
	@Override
	public void displayStd() 
	{
		Session session = HiberUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "FROM Student";
		Query <Student> query = session.createQuery(hql,Student.class);
		List <Student> resultList = query.getResultList();
		
		for(Student entity : resultList) {
			System.out.println("Emp ID : " + entity.getStdid());
			System.out.println("First Name : " + entity.getStdname());
			System.out.println("Surname : " + entity.getStdsurname());
			System.out.println("Date Of Birth : " + entity.getDob());
			System.out.println("Gender : " + entity.getStdgender());
			System.out.println("Email Id : " + entity.getStdemail());
			System.out.println("Phone Number : " + entity.getStdphone());
		}
		
		
	
	}

}
