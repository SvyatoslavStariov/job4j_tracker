package ru.job4j.pojo;

import java.time.LocalDate;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Statikov Svyatoslav Sergeevich");
        student.setGroup("Java");
        student.setDateAdmission(LocalDate.of(2023, 2, 24));
        System.out.printf("Student with full name: %s, group: %s, date admission: %s%n",
                student.getFullName(),
                student.getGroup(),
                student.getDateAdmission());
    }
}