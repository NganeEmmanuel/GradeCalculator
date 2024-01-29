package com.gradecalculator.gradecalculator.service.performanceService;

import com.gradecalculator.gradecalculator.dao.EntityDao.PerformanceDao;
import com.gradecalculator.gradecalculator.model.Performance;

public class PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceService() {
        this.performanceDao = new PerformanceDao();
    }

    public PerformanceService(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    public void addPerformance(Performance performance) {
        performanceDao.add(performance);
    }
}
