package com.maks.JDBC.task2.domain;

public class Teacher {
    private Integer id;
    private String name;
    private Integer subject;
    private Integer countSubjects;

    public Teacher(final Integer id, final String name, final Integer subject, final Integer countSubjects) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.countSubjects = countSubjects;
    }

    public Teacher(final String name, final Integer subject, final Integer countSubjects) {
        this.name = name;
        this.subject = subject;
        this.countSubjects = countSubjects;
    }

    public Teacher() {
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

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(final Integer subject) {
        this.subject = subject;
    }

    public Integer getCountSubjects() {
        return countSubjects;
    }

    public void setCountSubjects(final Integer countSubjects) {
        this.countSubjects = countSubjects;
    }
}
