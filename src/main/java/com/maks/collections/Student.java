package com.maks.collections;

import java.util.ArrayList;
import java.util.List;

public class Student {
    final String name;
    int group;
    int course;
    int math;
    int biology;
    int physics;

    public Student(final String name, final int group, final int course, final int math, final int biology, final int physics) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.math = math;
        this.biology = biology;
        this.physics = physics;
    }

    public int averageValue(final int math, final int biology, final int physics) {
        int value = (math + biology + physics) / 3;
        return value;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", course=" + course +
                ", math=" + math +
                ", biology=" + biology +
                ", physics=" + physics +
                '}';
    }
}
