package com.example.course_mangement.Repository;

import com.example.course_mangement.entity.Comment;
import com.example.course_mangement.entity.Course;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class CourseRepository {
    private final EntityManager entityManager;

    public Course addCourse(Course course){
        entityManager.persist(course);
        return course;
    }
    public Course addedComments(Long id , List<Comment> commentList){
        Course course = entityManager.find(Course.class , id);
        for(Comment comment : commentList){
            comment.setCourse(course);
            entityManager.persist(comment);
            course.addComment(comment);
        }
        return course;
    }

    public Course findCourse(Long id){
        Course course = entityManager.find(Course.class , id);
        course.getComments();
        return course;
    }

    public Comment getComment(Long id){
        Comment comment = entityManager.find(Comment.class , id);
        return comment;
    }
}
