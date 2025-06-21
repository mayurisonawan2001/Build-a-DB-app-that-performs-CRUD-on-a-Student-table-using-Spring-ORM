package com.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        // INSERT
        Student s1 = new Student(101, "Mayuri", "Pune");
        int result = studentDao.insert(s1);
        System.out.println("Inserted: " + result);

        // GET ONE
        Student s2 = studentDao.getStudent(101);
        System.out.println("Fetched: " + s2);

        // UPDATE
        s2.setStudentCity("Mumbai");
        studentDao.updateStudent(s2);
        System.out.println("Updated");

        // GET ALL
        List<Student> students = studentDao.getAllStudents();
        for (Student s : students) {
            System.out.println(s);
        }

        // DELETE
        studentDao.deleteStudent(101);
        System.out.println("Deleted");
    }
}
