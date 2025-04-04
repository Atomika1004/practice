package org.example.comparators.university;

import org.example.comparators.UniversityComparator;
import org.example.model.University;

public class UniversityYearsOfFoundComparator implements UniversityComparator {

    @Override
    public int compare(University o1, University o2) {
        return Float.compare(o1.getYearOfFound(), o2.getYearOfFound());
    }
}
