package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

@Transactional
public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    public int insert(Student student) {
        return (int) this.hibernateTemplate.save(student);
    }

    public Student getStudent(int studentId) {
        return this.hibernateTemplate.get(Student.class, studentId);
    }

    public List<Student> getAllStudents() {
        return this.hibernateTemplate.loadAll(Student.class);
    }

    public void deleteStudent(int studentId) {
        Student s = this.hibernateTemplate.get(Student.class, studentId);
        if (s != null) {
            this.hibernateTemplate.delete(s);
        }
    }

    public void updateStudent(Student student) {
        this.hibernateTemplate.update(student);
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
