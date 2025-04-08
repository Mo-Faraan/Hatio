package com.example;

import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

// @Embeddable
@Entity
public class Laptop {

    @Id
    private int lid;
    private String model;
    private String brand;
    private int ram;
    // @ManyToOne
    // @ManyToMany(mappedBy = "laptops")
    // private List<alien> aliens;
    
    
    // public List<alien> getAliens() {
    //     return aliens;
    // }

    // public void setAliens(List<alien> aliens) {
    //     this.aliens = aliens;
    // }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Laptop [lid=" + lid + ", model=" + model + ", brand=" + brand + ", ram=" + ram + "]";
    }
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
     
    
}
