package com.CourseApplication;

import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.CourseApplication.DAO.Dao;
import com.CourseApplication.model.Course;

@SpringBootApplication
public class CourseAppApplication {
	//getting an instance of the DAO
	private static Dao<Course> dao;
	
	public CourseAppApplication(Dao<Course> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseAppApplication.class, args);
		
		//testing dao functionalities
		//creating a new course
		System.out.println("\nCreate Course ------------- \n");
		Course springVue = new Course("Spring boot + vue", "New Course", "Http://vue");
		dao.create(springVue);
				
		
		System.out.println("One course -------------------- \n");
		Optional<Course> firstOne = dao.get(1);
		System.out.println(firstOne.get());
		
		
		//updating a course
		System.out.println("\nUpdating a course ----------- \n");
		//updating the description for springVue
		springVue.setDescription("Learn to build apps using pring vue");
		dao.update(springVue, 5);
		
		//deleting a course
		dao.delete(4);
		
		//printing all courses to the console
		System.out.println("\nAll courses ------------------- \n");
		List<Course> courses = dao.list();
		courses.forEach(System.out::println);
	}

}
