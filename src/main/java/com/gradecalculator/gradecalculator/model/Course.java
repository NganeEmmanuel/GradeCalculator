package com.gradecalculator.gradecalculator.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@SuppressWarnings("unused")
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_instructor")
    private User courseInstructor;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_code")
    private String courseCode;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "course")
    private List<Performance> performances;

    public Course() {
    }

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(User courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseInstructor=" + courseInstructor +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
