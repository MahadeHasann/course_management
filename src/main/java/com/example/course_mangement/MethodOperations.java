package com.example.course_mangement;

import com.example.course_mangement.Repository.CourseRepository;
import com.example.course_mangement.Repository.StudentRepository;
import com.example.course_mangement.entity.Comment;
import com.example.course_mangement.entity.Course;
import com.example.course_mangement.entity.Passport;
import com.example.course_mangement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MethodOperations {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;
//   @Transactional(rollbackFor = RuntimeException.class)
//    void test2() {
//        Student student = studentRepository.addStudent(new Student("Rohim"));
//        System.out.println(student);
//        if(student != null)
//            throw new RuntimeException("exception");
//        Student studentTwo = studentRepository.addPassport(student.getId(),new Passport("Mahade_Passport"));
//        System.out.println(studentTwo);
//
//        Passport passport = studentRepository.getPassport(1L);
//        System.out.println(passport);
//    }

    @Transactional(rollbackFor = RuntimeException.class)
    void test2() {
        Course course = courseRepository.addCourse(new Course("Math"));
        System.out.println("SINGLE COURSE-------> "+course);
        List<Comment> commentList = List.of(new Comment("COM1"),
                new Comment("COM2"),
                new Comment("COM3"));
        Course courseRes = courseRepository.addedComments(course.getId(),commentList);
//        System.out.println("COURSE:----------> " +courseRes);
//
//        Course findCourse = courseRepository.findCourse(1l);
//        System.out.println("find -------->"+findCourse);

        Comment comment = courseRepository.getComment(1l);
        System.out.println("Comment --------->"+comment);
    }
}
