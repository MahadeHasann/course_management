package com.example.course_mangement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity(name = "comment")
@ToString
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    public Comment(){}
    public Comment(String description){
        this.description = description;
    }
}
