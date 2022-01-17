package com.maks.JDBC.task2.repository;

import com.maks.JDBC.task2.domain.SubjectInSchedule;

import java.util.List;

public interface SubjectInScheduleRepository extends MainRepository<SubjectInSchedule> {

    List<String> getDaysByCountSubject(Integer specifiedCount);

    List<String> getDaysByCountAuditorium(Integer specifiedCount);

    void transferFirstSubjectByDay(String day);
}
