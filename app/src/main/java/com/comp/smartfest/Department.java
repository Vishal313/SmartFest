package com.comp.smartfest;

public class Department {

    private String complain;
    private String Dept;

    public  Department(){

    }

    public Department(String complain, String dept) {
        this.complain = complain;
        this.Dept = dept;

    }

    public String getComplain() {
        return complain;
    }

    public String getDept() {
        return Dept;
    }

}

