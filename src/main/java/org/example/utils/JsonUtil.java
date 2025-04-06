package org.example.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Student;
import org.example.model.University;
import org.example.IO.xlsx.ReaderXLSX;
import com.google.gson.Gson;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {}

    public static String toJson(Object obj) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
    }

    public static String toJson(List<?> data) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(data);
    }
}
