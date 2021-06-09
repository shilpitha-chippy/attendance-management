package com.example.attendance;

import java.util.Date;

public class AttModelClass {
    String date;
    String classs;
    int rollno;
    String name;
    String status;

    public AttModelClass(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public AttModelClass(String date, String classs, int rollno, String name, String status) {
        this.date = date;
        this.classs = classs;
        this.rollno = rollno;
        this.name = name;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
