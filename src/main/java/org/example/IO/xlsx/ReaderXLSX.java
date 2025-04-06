package org.example.IO.xlsx;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.model.Student;
import org.example.model.University;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class ReaderXLSX {
    private final List<Student> studentList;
    private final List<University> universityList;

    private ReaderXLSX() {
        this.studentList = getStudentList();
        this.universityList = getUniversitytList();
    }

    public static List<Student> getStudentList() {
        ArrayList<String> stringValues = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("src/main/resources/universityInfo.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            XSSFSheet mysheet = myWorkBook.getSheetAt(0);
            Iterator<Row> rowIterator = mysheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    if (row.getRowNum() == 0) {
                        break;
                    }
                    Cell cell = cellIterator.next();
                    stringBuilder.append(cell).append(";");
                }
                if (!stringBuilder.isEmpty()) {
                    stringValues.add(stringBuilder.toString());
                }
                stringBuilder.delete(0, stringBuilder.length());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return parseStudent(stringValues);
    }

    public static List<Student> parseStudent(List<String> strings) {
        List<Student> students = new ArrayList<>();
        for (String string : strings) {
            String[] split = string.split(";");
            try {
                students.add(Student.builder()
                        .universityId(split[0])
                        .fullName(split[1])
                        .currentCourseNumber(Float.parseFloat(split[2]))
                        .avgExamScore(Float.parseFloat(split[3]))
                        .build()
                );
            }catch (IndexOutOfBoundsException e){
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return students;
    }

    public static List<University> getUniversitytList() {
        List<String> stringValues = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File("/Users/atomika/Downloads/universityInfo.xlsx");
        try {
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
            XSSFSheet mysheet = myWorkBook.getSheetAt(1);
            Iterator<Row> rowIterator = mysheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    if (row.getRowNum() == 0) {
                        break;
                    }
                    Cell cell = cellIterator.next();
                    stringBuilder.append(cell).append(";");
                }
                if (!stringBuilder.isEmpty()) {
                    stringValues.add(stringBuilder.toString());
                }

                stringBuilder.delete(0, stringBuilder.length());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return parseUniversity(stringValues);
    }

    public static List<University> parseUniversity(List<String> strings) {
        List<University> universities = new ArrayList<>();
        for (String string : strings) {
            String[] split = string.split(";");
            try {
                universities.add(University.builder()
                                .id(split[0])
                                .fullName(split[1])
                                .shortname(split[2])
                                .yearOfFound(Float.parseFloat(split[3]))
                                .studyProfile(StudyProfile.valueOf(split[4]))
                        .build()
                );
            }catch (IndexOutOfBoundsException e){
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return universities;
    }
}
