package com.pdas.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Course;
import com.pdas.hibernate.demo.entity.Instructor;
import com.pdas.hibernate.demo.entity.InstructorDetail;
import com.pdas.hibernate.demo.entity.Review;
import com.pdas.hibernate.demo.entity.Student;

public class AddCoursesForProsenjitDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
		                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
		                .addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			
			// start a transaction
			session.beginTransaction();
			
			// get the student Prosenjit from db
			int studentId = 2;
			Student student = session.get(Student.class, studentId);
			System.out.println("\nLoaded student: " + student);
			System.out.println("Courses: " + student.getCourses());
			
			// create more courses
			Course course1 = new Course("Rubik's Cube - How tp Speed Cube");
			Course course2 = new Course("Atari 2600 - Game Development");
			
			// add student to course
			course1.addStudent(student);
			course2.addStudent(student);
			
			// save the courses
			System.out.println("\nSaving the courses...");
			session.save(course1);
			session.save(course2);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}
