package com.maks.JDBC.task2.controller;

import com.maks.JDBC.task2.domain.Subject;
import com.maks.JDBC.task2.domain.SubjectInSchedule;
import com.maks.JDBC.task2.domain.Teacher;
import com.maks.JDBC.task2.service.ScheduleService;
import com.maks.JDBC.task2.service.SubjectService;
import com.maks.JDBC.task2.service.TeacherService;

import java.util.List;

public class Controller {
    private static final String[] days = new String[]{
            "Zero day",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"};

    public static void createData() {
        //create subjects
        Subject subject = new Subject("math", 150, 24);
        final Subject math = SubjectService.createSubject(subject);
        subject = new Subject("programming", 200, 7);
        final Subject programming = SubjectService.createSubject(subject);
        subject = new Subject("testing", 90, 28);
        final Subject testing = SubjectService.createSubject(subject);
        subject = new Subject("algorithms", 130, 10);
        final Subject algorithms = SubjectService.createSubject(subject);
        subject = new Subject("psychology", 60, 10);
        final Subject psychology = SubjectService.createSubject(subject);


        //create teachers
        Teacher teacher = new Teacher("Maksim Ivanovich", math.getId(), 3);
        final Teacher mMath = TeacherService.createTeacher(teacher);
        teacher = new Teacher("Maksim Ivanovich", programming.getId(), 2);
        final Teacher mProgram = TeacherService.createTeacher(teacher);
        teacher = new Teacher("Maksim Ivanovich", algorithms.getId(), 1);
        final Teacher mAlgoritm = TeacherService.createTeacher(teacher);
        teacher = new Teacher("Aleksandr Genadievich", programming.getId(), 1);
        final Teacher aProgram = TeacherService.createTeacher(teacher);
        teacher = new Teacher("Aleksandr Genadievich", testing.getId(), 2);
        final Teacher aTesting = TeacherService.createTeacher(teacher);
        teacher = new Teacher("Aleksandr Genadievich", algorithms.getId(), 1);
        final Teacher aAlgoritm = TeacherService.createTeacher(teacher);
        teacher = new Teacher("Ekaterina Pavlovna", psychology.getId(), 2);
        final Teacher ePsychology = TeacherService.createTeacher(teacher);

        //create schedule
        SubjectInSchedule subjectInSchedule = new SubjectInSchedule(mMath.getId(), days[1], 9);
        final SubjectInSchedule subjectInSchedule1 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(aProgram.getId(), days[1], 10);
        final SubjectInSchedule subjectInSchedule2 = ScheduleService.addSubjectToSchedule(subjectInSchedule);

        subjectInSchedule = new SubjectInSchedule(mProgram.getId(), days[2], 9);
        final SubjectInSchedule subjectInSchedule3 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(aTesting.getId(), days[2], 10);
        final SubjectInSchedule subjectInSchedule4 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(aAlgoritm.getId(), days[2], 11);
        final SubjectInSchedule subjectInSchedule5 = ScheduleService.addSubjectToSchedule(subjectInSchedule);

        subjectInSchedule = new SubjectInSchedule(mMath.getId(), days[3], 9);
        final SubjectInSchedule subjectInSchedule6 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(ePsychology.getId(), days[3], 10);
        final SubjectInSchedule subjectInSchedule7 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(ePsychology.getId(), days[3], 11);
        final SubjectInSchedule subjectInSchedule8 = ScheduleService.addSubjectToSchedule(subjectInSchedule);

        subjectInSchedule = new SubjectInSchedule(mAlgoritm.getId(), days[4], 9);
        final SubjectInSchedule subjectInSchedule9 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(aTesting.getId(), days[4], 10);
        final SubjectInSchedule subjectInSchedule10 = ScheduleService.addSubjectToSchedule(subjectInSchedule);

        subjectInSchedule = new SubjectInSchedule(mProgram.getId(), days[5], 11);
        final SubjectInSchedule subjectInSchedule11 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(mMath.getId(), days[5], 9);
        final SubjectInSchedule subjectInSchedule12 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
        subjectInSchedule = new SubjectInSchedule(ePsychology.getId(), days[5], 10);
        final SubjectInSchedule subjectInSchedule13 = ScheduleService.addSubjectToSchedule(subjectInSchedule);
    }


    public static List<Teacher> getTeachersByDayAndAuditorium(final String requiredDay, final Integer requiredAuditorium) {
        return TeacherService.getTeachersByDayAndAuditorium(requiredDay, requiredAuditorium);
    }

    public static List<Teacher> getTeachersNotWorkingOnDAy(final String requiredDay) {
        return TeacherService.getTeachersNotWorkingOnDAy(requiredDay);
    }

    public static List<String> getDaysByCountSubject(final Integer specifiedCount) {
        return ScheduleService.getDaysByCountSubject(specifiedCount);
    }

    public static List<String> getDaysByCountAuditorium(final Integer specifiedCount) {
        return ScheduleService.getDaysByCountAuditorium(specifiedCount);
    }

    public static void transferFirstSubjectByDays(final List<String> daysToTransfer) {
        for (final String day : daysToTransfer) {
            ScheduleService.transferFirstSubjectByDay(day);
        }
    }
}
