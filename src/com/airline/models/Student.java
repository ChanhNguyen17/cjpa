package com.airline.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Entity implementation class for Entity: Student
 *
 */

@Entity
public class Student implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    public Student() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double age;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getAge() {
        return age;
    }
    public void setAge(Double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id
                + ", name=" + name
                + ", age=" + age + "]";
    }
}
