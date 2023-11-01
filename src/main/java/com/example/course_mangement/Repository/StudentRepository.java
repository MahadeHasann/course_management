package com.example.course_mangement.Repository;

import com.example.course_mangement.entity.Course;
import com.example.course_mangement.entity.Passport;
import com.example.course_mangement.entity.Student;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class StudentRepository {

    private final EntityManager entityManager;

    public Student findStudent(Long id){
        Student student = entityManager.find(Student.class,id);
        return student;
    }


    public Student addStudent(Student student){
        entityManager.persist(student);
        return student;
    }


    public Student addPassport(Long id ,Passport passport){
        Student student = entityManager.find(Student.class , id);
        student.setPassport(passport);
        entityManager.persist(passport);
        return student;
    }

    public Passport getPassport(Long id){
        Passport passport = entityManager.find(Passport.class , id);
        return passport;
    }

    public Student addCourseToStudent(Long id , List<Course> courseList){
        Student student = entityManager.find(Student.class , id);
        for(Course course : courseList){
            student.addCourse(course);
            course.addStudent(student);
            entityManager.persist(course);
        }
        return student;
    }

}
