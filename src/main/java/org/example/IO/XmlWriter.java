package org.example.IO;

import org.example.model.AllInfoObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class XmlWriter {
    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    public static void xmlMarshaling (AllInfoObject allInfoObject){
        Path dir = Path.of("xmlReqs");
        try {
            Files.createDirectory(dir);
        } catch (IOException e) {
            logger.info("Директория уже создана " + dir);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            JAXBContext context = JAXBContext.newInstance(AllInfoObject.class);
            Marshaller mar= context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(allInfoObject, new File("xmlReqs/req_" + dateFormat.format(new Date()) + ".xml"));
        } catch (JAXBException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
    }
}
