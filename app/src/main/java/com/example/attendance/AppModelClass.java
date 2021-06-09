package com.example.attendance;

public class AppModelClass {

    Integer id;
    String uname;
    String pass;

    String rno;
    String name;
    String classs;

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public AppModelClass(Integer id, String uname, String pass, Integer t, Integer p, Integer a) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.t = t;
        this.p = p;
        this.a = a;
    }

    Integer t,p,a;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public AppModelClass(String rno, String name, String classs) {
        this.rno = rno;
        this.name = name;
        this.classs = classs;
    }


    public AppModelClass(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
    }

    public AppModelClass(Integer id, String uname, String pass) {
        this.id = id;
        this.uname = uname;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
