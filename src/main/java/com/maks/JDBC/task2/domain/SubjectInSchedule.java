package com.maks.JDBC.task2.domain;

public class SubjectInSchedule {
    private Integer id;
    private Integer teacherWithSubject;
    private String day;
    private Integer time;

    public SubjectInSchedule(final Integer teacherWithSubject, final String day, final Integer time) {
        this.teacherWithSubject = teacherWithSubject;
        this.day = day;
        this.time = time;
    }

    public SubjectInSchedule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getTeacherWithSubject() {
        return teacherWithSubject;
    }

    public void setTeacherWithSubject(final Integer teacherWithSubject) {
        this.teacherWithSubject = teacherWithSubject;
    }

    public String getDay() {
        return day;
    }

    public void setDay(final String day) {
        this.day = day;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(final Integer time) {
        this.time = time;
    }
}
