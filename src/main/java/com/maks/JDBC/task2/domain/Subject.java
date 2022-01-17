package com.maks.JDBC.task2.domain;

public class Subject {
    private Integer id;
    private String name;
    private Integer count_students;
    private Integer auditorium;

    public Subject(final String name, final Integer count_students, final Integer auditorium) {
        this.name = name;
        this.count_students = count_students;
        this.auditorium = auditorium;
    }

    public Subject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getCount_students() {
        return count_students;
    }

    public void setCount_students(final Integer count_students) {
        this.count_students = count_students;
    }

    public Integer getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(final Integer auditorium) {
        this.auditorium = auditorium;
    }
}
