/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Guitar {

    private int guitarId;
    private String brand;
    private String type;
    private int year;
    private double price;

    // Constructor
    public Guitar(int guitarId, String brand, String type, int year, double price) {
        this.guitarId = guitarId;
        this.brand = brand;
        this.type = type;
        this.year = year;
        this.price = price;
    }

    // Getters and Setters
    public int getGuitarId() {
        return guitarId;
    }

    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + " " + type + " (" + year + ")";
    }
}
