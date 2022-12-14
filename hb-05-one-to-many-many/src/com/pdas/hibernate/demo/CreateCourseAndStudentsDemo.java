package com.pdas.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pdas.hibernate.demo.entity.Course;
import com.pdas.hibernate.demo.entity.Instructor;
import com.pdas.hibernate.demo.entity.InstructorDetail;
import com.pdas.hibernate.demo.entity.Review;

public class CreateCourseAndStudentsDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
		                .addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
		                .addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			Course course = new Course("Pacman - How to score one million points");
			
			// add some reviews
			course.addReview(new Review("Great Course... loved it"));
			course.addReview(new Review("Cool course, good job well done"));
			course.addReview(new Review("What a dumb course, you are an idiot!"));
			
			// save the course... and leverage the cascade all :-)
			System.out.println("Saving the course...");
			System.out.println(course);
			System.out.println(course.getReviews());
			session.save(course);
			
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
