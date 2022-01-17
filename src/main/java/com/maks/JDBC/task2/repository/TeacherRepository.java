package com.maks.JDBC.task2.repository;

import com.maks.JDBC.task2.domain.Teacher;

import java.util.List;

public interface TeacherRepository extends MainRepository<Teacher> {

    List<Teacher> getTeachersByDayAndAuditorium(String requiredDay, Integer requiredAuditorium);

    List<Teacher> getTeachersNotWorkingOnDAy(String requiredDay);
}
