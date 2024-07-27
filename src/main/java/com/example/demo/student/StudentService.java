package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
//    public Student getStudentById(Long id){
//        return studentRepository.findById(id);
//    }

    public void addNewStudent(Student student){
        System.out.println(student);
        Optional<Student> studentsByEmail= studentRepository.findStudentsByEmail(student.getEmail());
        if (studentsByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("student does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findStudentById(studentId);

    }

    @Transactional
    public Student updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student not found"));
        if (name != null &&
                !name.isEmpty() &&
                !Objects.equals(student.getFirstName(), name)){
            student.setFirst_name(name);
        }

        if (email != null &&
                !Objects.equals(student.getEmail(), email)
        ) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentsByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
        return student;
    }
}
