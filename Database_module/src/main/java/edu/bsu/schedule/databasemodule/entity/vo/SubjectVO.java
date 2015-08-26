package edu.bsu.schedule.databasemodule.entity.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class SubjectVO implements Serializable {
    private static final long serialVersionUID = 229328312354228305L;
    private String subjectName;
    private Timestamp subjectTime;
    private String cabinet;
    private String teacherName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Timestamp getSubjectTime() {
        return subjectTime;
    }

    public void setSubjectTime(Timestamp subjectTime) {
        this.subjectTime = subjectTime;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
