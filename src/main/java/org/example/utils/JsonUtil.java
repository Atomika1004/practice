package org.example.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Student;
import org.example.model.University;
import org.example.xlsx.ReaderXLSX;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JsonUtil {

    private JsonUtil() {}

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String studentsToJson(List<Student> student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universitiesToJson(List<University> university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static List<Student> jsonToListStudents(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static List<University> jsonToListUniversities(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        // Сериализация в JSON
        String json = gson.toJson(ReaderXLSX.getStudentList().get(1));
        System.out.println("JSON: " + json);

        // Десериализация из JSON
        Student deserializedPerson = gson.fromJson(json, Student.class);
        System.out.println("Объект: " + deserializedPerson);
    }
}
