package com.example.demo;

import com.example.demo.Course.Course;
import com.example.demo.Course.CourseRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



//	@Bean
//	CommandLineRunner commandLineRunner(StudentRepository studentRepository, CourseRepository courseRepository){
//		return args -> {
//			Student maria = new Student(
//					"Maria", "Jones", "maria@gmail.com", 21
//			);
//			studentRepository.save(maria);
//
//			Student nuh = new Student(
//					"Nuh", "saidi", "nuh@gmail.com", 22
//			);
//			studentRepository.save(nuh);
//
//			Course java = new Course(
//					"cs31", "java", "ni ngumu", 2002
//			);
//			Course architecture = new Course(
//					"cs11", "architecture", "ni ngumu", 2002
//			);
//			courseRepository.save(architecture);
//			Course signal = new Course(
//					"cs311", "signal", "ni ngumu", 2002
//			);
//			courseRepository.save(java);
//			courseRepository.save(signal);
//		};
//	}
}
