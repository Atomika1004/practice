package org.example.IO;

import com.google.gson.GsonBuilder;
import org.example.model.AllInfoObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    public static void toJsonFile (AllInfoObject allInfoObject) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(allInfoObject);
        Path path = Path.of("jsonReqs");
        try {
            Files.createDirectory(path);
            logger.info("создана директория " + path);
        } catch (IOException e) {
            logger.info("директория " + path + " уже создана");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try (FileOutputStream outputStream = new FileOutputStream("jsonReqs/req_" + dateFormat.format(new Date()) + ".json")) {
            outputStream.write(json.getBytes());
            logger.info("Данные успешно записаны в файл req.json");
        } catch (IOException e) {
            logger.info("Запись данных не удалась " + e.getMessage());
            e.printStackTrace();
        }
    }
}
