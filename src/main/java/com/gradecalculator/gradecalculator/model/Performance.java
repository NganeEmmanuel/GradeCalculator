package com.gradecalculator.gradecalculator.model;

import jakarta.persistence.*;

@SuppressWarnings("unused")
@Entity
public class Performance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    @Column(name = "home_work_score")
    private Double homeWorkScore;
    @Column(name = "ca_scores")
    private Double caScore;
    @Column(name = "exam_score")
    private Double examScore;
    @Column(name = "project_score")
    private Double projectScore;
    @Column(name = "attendance_score")
    private Double attendanceScore;
    @Column(name = "participation_score")
    private Double participationScore;
    private String grade;

    public Performance() {
    }

    public Performance(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getHomeWorkScore() {
        return homeWorkScore;
    }

    public void setHomeWorkScore(Double homeWorkScore) {
        this.homeWorkScore = homeWorkScore;
    }

    public Double getCaScore() {
        return caScore;
    }

    public void setCaScore(Double caScore) {
        this.caScore = caScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Double getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(Double projectScore) {
        this.projectScore = projectScore;
    }

    public Double getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(Double attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public Double getParticipationScore() {
        return participationScore;
    }

    public void setParticipationScore(Double participationScore) {
        this.participationScore = participationScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public java.lang.String toString() {
        return "Performance{" +
                "id=" + id +
//                ", student=" + student +
                ", course=" + course +
                ", homeWorkScore=" + homeWorkScore +
                ", caScore=" + caScore +
                ", examScore=" + examScore +
                ", projectScore=" + projectScore +
                ", AttendanceScore=" + attendanceScore +
                ", participationScore=" + participationScore +
                ", grade=" + grade +
                '}';
    }
}
