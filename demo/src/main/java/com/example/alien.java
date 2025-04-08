package com.example;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
// @Table(name = "alien_table")

public class alien {
    @Id
    private int aid;
    // @Column(name="alien_name")
    private String aname;
    // @Transient
    private String atech;
    // @OneToOne
    // @OneToMany(mappedBy = "a")
    // @ManyToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
    public List<Laptop> getLaptops() {
        return laptops;
    }
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }
    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }
    public String getAtech() {
        return atech;
    }
    public void setAtech(String atech) {
        this.atech = atech;
    }
    @Override
    public String toString() {
        return "alien [aid=" + aid + ", aname=" + aname + ", atech=" + atech + ", laptops=" + laptops + "]";
    }
    
}
