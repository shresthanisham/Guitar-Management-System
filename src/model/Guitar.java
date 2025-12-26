/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
/**
 *
 * @author Dell
 */
public class Guitar {
    

    private int guitarId;
    private String modelName;
    private String brand;
    private String type;        // Acoustic, Electric, Bass
    private int year;
    private String condition;   // New, Used
    private double price;
    private int stockQty;
    private final LocalDate addedDate;

    // Constructor
    public Guitar(int guitarId, String modelName, String brand, String type,
                  int year, String condition, double price, int stockQty) {
        this.guitarId = guitarId;
        this.modelName = modelName;
        this.brand = brand;
        this.type = type;
        this.year = year;
        this.condition = condition;
        this.price = price;
        this.stockQty = stockQty;
        this.addedDate = LocalDate.now();
    }

    // Getters and Setters
    public int getGuitarId() {
        return guitarId;
    }

    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    @Override
    public String toString() {
        return modelName + " (" + brand + ", " + year + ")";
    }
}

