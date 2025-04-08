package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class student {
    @Id
    private int rno;
    private String sname;
    private int sage;
    public int getRno() {
        return rno;
    }
    public void setRno(int rno) {
        this.rno = rno;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public int getSage() {
        return sage;
    }
    public void setSage(int sage) {
        this.sage = sage;
    }
    @Override
    public String toString() {
        return "student [rno=" + rno + ", sname=" + sname + ", sage=" + sage + "]";
    }
    
    
}
