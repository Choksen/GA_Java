package com.maks.JDBC.task1.domain;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private Date birthday;

    public Person(final String name, final Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Person(final int id, final String name, final Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
