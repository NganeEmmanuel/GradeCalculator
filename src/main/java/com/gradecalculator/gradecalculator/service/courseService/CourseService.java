package com.gradecalculator.gradecalculator.service.courseService;

import com.gradecalculator.gradecalculator.dao.EntityDao.CourseDao;
import com.gradecalculator.gradecalculator.model.Course;

import java.util.List;

public class CourseService {
    private final CourseDao courseDao;

    public CourseService() {
        this.courseDao = new CourseDao();
    }

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }
}
