package bc.desafio_spring.meli_social.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    private UUID id;
    private Date date;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private int category;
    private double price;

    public String getBrand() {
        return brand;
    }
    public int getCategory() {
        return category;
    }
    public String getColor() {
        return color;
    }public Date getDate() {
        return date;
    }public UUID getId() {
        return id;
    }public String getNotes() {
        return notes;
    }public double getPrice() {
        return price;
    }public String getType() {
        return type;
    }public String getProductName() {
        return productName;
    }public Seller getSeller() {
        return seller;
    }public void setBrand(String brand) {
        this.brand = brand;
    }public void setCategory(int category) {
        this.category = category;
    }public void setColor(String color) {
        this.color = color;
    }public void setDate(Date date) {
        this.date = date;
    }public void setId(UUID id) {
        this.id = id;
    }public void setNotes(String notes) {
        this.notes = notes;
    }public void setPrice(double price) {
        this.price = price;
    }public void setProductName(String productName) {
        this.productName = productName;
    }public void setSeller(Seller seller) {
        this.seller = seller;
    }public void setType(String type) {
        this.type = type;
    }

}
