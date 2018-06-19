package com.airline.service;

import com.airline.models.Student;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Session Bean implementation class PassengerService
 */
@Stateless
@LocalBean
public class StudentService {
    /**
     * Default constructor.
     */
    public StudentService() {
        // TODO Auto-generated constructor stub
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cjpa");
    private EntityManager em = emf.createEntityManager();

    public void addStudent(Student stu) {
        em.persist(stu);
    }

    public List<Student> getStudents() {
        TypedQuery<Student> query = em.createQuery("SELECT stu FROM Student stu", Student.class);
        List<Student> stuList  = query.getResultList();
        return stuList;
    }
}
