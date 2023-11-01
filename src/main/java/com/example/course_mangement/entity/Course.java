package com.example.course_mangement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "course")
@ToString(exclude = {"comments","studentList"})
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String courseName;
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();
    public Course(String courseName){
        this.courseName = courseName;
    }
    public Course(){}

    public void addStudent(Student student){
        if(studentList == null ) studentList = new ArrayList<>();
        studentList.add(student);
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
    }


}
