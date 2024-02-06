package com.gradecalculator.gradecalculator.service.reportService;

import com.gradecalculator.gradecalculator.model.Performance;
import com.gradecalculator.gradecalculator.model.Student;
import com.gradecalculator.gradecalculator.service.studentService.StudentService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;


public class ReportGeneratorService {
    private static final StudentService studentService = new StudentService();

    public static void generateReport(Long id) {
        Student student = studentService.getStudentByID(id);
        if (student != null) {
            List<Performance> performances = student.getPerformances();

            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(getReportFilePath()));
                WritableSheet sheet = workbook.createSheet("Student Report Card", 0);

                String[] columns = {"Performance ID", "Exam Score", "Assignment Score", "CA Score", "Project Score", "Attendance Score", "Participation Score", "Grade"};

                // Write column headers
                for (int i = 0; i < columns.length; i++) {
                    Label header = new Label(i, 0, columns[i]);
                    sheet.addCell(header);
                }

                // Write performance data
                int rowNum = 1;
                for (Performance performance : performances) {
                    sheet.addCell(new Label(0, rowNum, String.valueOf(performance.getId())));
                    sheet.addCell(new Label(1, rowNum, String.valueOf(performance.getExamScore())));
                    sheet.addCell(new Label(2, rowNum, String.valueOf(performance.getHomeWorkScore())));
                    sheet.addCell(new Label(3, rowNum, String.valueOf(performance.getCaScore())));
                    sheet.addCell(new Label(4, rowNum, String.valueOf(performance.getProjectScore())));
                    sheet.addCell(new Label(5, rowNum, String.valueOf(performance.getAttendanceScore())));
                    sheet.addCell(new Label(6, rowNum, String.valueOf(performance.getParticipationScore())));
                    sheet.addCell(new Label(7, rowNum, performance.getGrade()));

                    rowNum++;
                }

                workbook.write();
                workbook.close();

                System.out.println("Student report generated successfully!");

            } catch (IOException | jxl.write.WriteException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getReportFilePath() throws IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "reports" + File.separator + "report.xls";
        Path outputPath = Path.of(filePath);
        Files.createDirectories(outputPath.getParent());
        Files.write(outputPath, new byte[0], StandardOpenOption.CREATE);

        return filePath;
    }
}