/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.GregorianCalendar;

/**
 *
 * @author Zueb LDA
 */
public class Product {

    private Long id;

    private String brand;

    private String model;

    private String version;

    private String description;

    private String category;

    private int stockQtt;

    private double sellPrice;

    private GregorianCalendar repoDate;

    public Product() {
    }

    public Product(Long id, String brand, String model, String version, String description, String category, int stockQtt, double sellPrice, GregorianCalendar repoDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.description = description;
        this.category = category;
        this.stockQtt = stockQtt;
        this.sellPrice = sellPrice;
        this.repoDate = repoDate;
    }

    public void setRepoDate(GregorianCalendar repoDate) {
        this.repoDate = repoDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStockQtt() {
        return stockQtt;
    }

    public void setStockQtt(int stockQtt) {
        this.stockQtt = stockQtt;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public GregorianCalendar getRepoDate() {
        return repoDate;
    }

}
