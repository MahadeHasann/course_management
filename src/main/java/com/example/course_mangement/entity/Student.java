package com.example.course_mangement.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "student")
@ToString(exclude = {"passport"})
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "STUDENT_ID",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "COURSE_ID",referencedColumnName = "id"))
    private List<Course> courseList ;

    public void addCourse(Course course){
        if(courseList == null ) courseList = new ArrayList<>();
        courseList.add(course);
    }

    public Student(String name){
        this.name = name;
    }
    public Student(){}
}
