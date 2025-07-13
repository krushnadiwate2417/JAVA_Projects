package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    private int rollNo;
    private String sName;
    private int sAge;
    @OneToMany
    private List<Laptop> laptops;

    public Student() {}

    public Student(int rollNo, String sName, int sAge, List<Laptop> laptops) {
        this.rollNo = rollNo;
        this.sName = sName;
        this.sAge = sAge;
        this.laptops = laptops;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public List<Laptop> getLaptop() {
        return laptops;
    }

    public void setLaptop(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", laptop=" + laptops +
                '}';
    }
}
