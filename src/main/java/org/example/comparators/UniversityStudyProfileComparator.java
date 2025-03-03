package org.example.comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.enums.StudyProfile;
import org.example.model.University;

public class UniversityStudyProfileComparator implements UniversityComparator{

    @Override
    public int compare(University o1, University o2) {
        if(o1.getStudyProfile() == null) {
            return 1;
        } else if(o2.getStudyProfile() == null) {
            return -1;
        }
        return StringUtils.compare(o1.getStudyProfile().name(), o2.getStudyProfile().name());
    }
}
