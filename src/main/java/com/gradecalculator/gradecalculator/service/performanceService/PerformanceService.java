package com.gradecalculator.gradecalculator.service.performanceService;

import com.gradecalculator.gradecalculator.dao.EntityDao.PerformanceDao;
import com.gradecalculator.gradecalculator.dao.EntityDao.StudentDao;
import com.gradecalculator.gradecalculator.model.Performance;
import com.gradecalculator.gradecalculator.model.Student;

import java.util.ArrayList;
import java.util.List;

public class PerformanceService {
    private final PerformanceDao performanceDao;
    private final StudentDao studentDao =  new StudentDao();

    public PerformanceService() {
        this.performanceDao = new PerformanceDao();
    }

    public PerformanceService(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    public void addPerformance(Performance performance) {
        performanceDao.add(performance);
    }

    public List<Performance> getPerformancesByUserId(Long id) {
        Student student = studentDao.findById(id).orElse(null);
        if(student != null) return student.getPerformances();
        return new ArrayList<>();
    }
}
