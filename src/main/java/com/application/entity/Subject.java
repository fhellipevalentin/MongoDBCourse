package com.application.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {

    @Field(name = "subject_name")
    private String subjectName;

    @Field(name = "marks_obtained")
    private Integer marksObtained;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Integer marksObtained) {
        this.marksObtained = marksObtained;
    }
}
