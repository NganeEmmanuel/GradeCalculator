package com.gradecalculator.gradecalculator.service.GradeCalculator;

import com.gradecalculator.gradecalculator.service.GradeCalculatorService.GradeCalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeCalculatorServiceTest {
    private GradeCalculatorService gradeCalculatorService;

    @BeforeEach
    public void setUp() {
        gradeCalculatorService = new GradeCalculatorService(
                10.0, 20.0, 20.0, 40.0, 5.0, 5.0
        );
    }

    @Test
    public void testCalculateGrade_APlus() {
        String grade = gradeCalculatorService.calculateGrade(9.5, 18.0, 18.0, 34.0, 4.0, 4.0);
        Assertions.assertEquals("B+", grade);
    }

    @Test
    public void testCalculateGrade_B() {
        String grade = gradeCalculatorService.calculateGrade(7.0, 14.0, 16.0, 28.0, 3.0, 3.0);
        Assertions.assertEquals("C+", grade);
    }

    @Test
    public void testCalculateGrade_F() {
        String grade = gradeCalculatorService.calculateGrade(5.0, 9.0, 6.0, 10.0, 2.0, 2.0);
        Assertions.assertEquals("F", grade);
    }

    @Test
    public void testAssessAssignmentScore() {
        Double score = gradeCalculatorService.assessAssignmentScore(8.0);
        Assertions.assertEquals(1.6, score, 0.01);
    }

    @Test
    public void testAssessCAScore() {
        Double score = gradeCalculatorService.assessCAScore(7.0);
        Assertions.assertEquals(1.4, score, 0.01);
    }

    @Test
    public void testAssessProjectScore() {
        Double score = gradeCalculatorService.assessProjectScore(9.0);
        Assertions.assertEquals(2.7, score, 0.01);
    }

    @Test
    public void testAssessExamScore() {
        Double score = gradeCalculatorService.assessExamScore(7.5);
        Assertions.assertEquals(1.5, score, 0.01);
    }

    @Test
    public void testAssessAttendanceScore() {
        Double score = gradeCalculatorService.assessAttendanceScore(4.0);
        Assertions.assertEquals(1.6, score, 0.01);
    }

    @Test
    public void testAssessParticipationScore() {
        Double score = gradeCalculatorService.assessParticipationScore(3.0);
        Assertions.assertEquals(1.2, score, 0.01);
    }

    @Test
    public void testAssessTotalScore() {
        Double totalScore = gradeCalculatorService.assessTotalScore(8.0, 7.0, 9.0, 7.5);
        Assertions.assertEquals(7.5600000000000005, totalScore, 0.01);
    }
}