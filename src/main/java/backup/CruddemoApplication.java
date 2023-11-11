package backup;

import com.jason.cruddemo.dao.AppDAO;
import com.jason.cruddemo.entity.Course;
import com.jason.cruddemo.entity.Instructor;
import com.jason.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			delteCourse(appDAO);
//			deleteInstructor(appDAO);
//			updateCourse(appDAO);
//			updateInstuctor(appDAO);

//			findInstructorWithCourses(appDAO);
//			createInstructorWithCourses(appDAO);
//			deleteInstructorDetail(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructor(appDAO);
//			findInstructor(appDAO);
//			createInstructor(appDAO);
		};
	}

	private void delteCourse(AppDAO appDAO) {
		appDAO.deleteCourseById(10);
	}

	private void updateCourse(AppDAO appDAO) {
		var id = 10;
		var course = appDAO.findCoursesById(id);
		course.setTitle("Enjoy the Simple Things");
		appDAO.update(course);
		System.out.println("done");
	}

	private void updateInstuctor(AppDAO appDAO) {
		var id = 1;
		var instructor = appDAO.findInstructorByIdJoinFetch(id);
		instructor.setLastName("TESTER");
		appDAO.update(instructor);
		System.out.println("done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		var id = 1;
		var instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());

//		Instructor instructor = appDAO.findInstructorById(id);
//		System.out.println("instructor: " + instructor);
//		List<Course> courses = appDAO.findCoursesByInstructorId(id);
//		System.out.println(courses);
		// not working due to lazy loading
//		System.out.println("instructor.couses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Susan", "Public", "susan@jason.com");
		InstructorDetail detail = new InstructorDetail("http://www.jason.com/youtube", "Video game");

		instructor.setInstructorDetail(detail);

		Course course1 = new Course("Air Guitar - Ultimate guide to guitar");
		Course course2 = new Course("Pinball master class");

		instructor.add(course1);
		instructor.add(course2);

		appDAO.save(instructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(6);
		System.out.println("removed");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail detail = appDAO.findInstructorDetailById(1);
		System.out.println(detail);
		System.out.println(detail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteInstructorById(id);
		System.out.println("removed");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id" + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor Detail: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Madhu", "Patel", "patel@jason.com");
		InstructorDetail detail = new InstructorDetail("http://www.jason.com/youtube", "Guitar");

//		Instructor instructor = new Instructor("Chad", "Darby", "darby@jason.com");
//		InstructorDetail detail = new InstructorDetail("http://www.jason.com/youtube", "Coding for future");
		instructor.setInstructorDetail(detail);
		System.out.println("instructor: " + instructor);
		appDAO.save(instructor);
		System.out.println("Instructor Save done");
	}

}
