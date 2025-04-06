package org.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllInfoObject {

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    List<Student> students;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    List<University> universities;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    List<Statistics> statistics;

    @XmlElement(name = "processedAt")
    private Date processDate;

}
