package bc.desafio_spring.meli_social.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bc.desafio_spring.meli_social.dto.NewPromoProductRequestDTO;

@Entity
public class PromProduct {

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    @Id
    private UUID id;
    private Date date;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount; 

    public PromProduct(
        NewPromoProductRequestDTO newProd
    ){
        this.id = newProd.getPostId();
        this.date = newProd.getDate();
        this.productName = newProd.getDetail().getProductName();
        this.type = newProd.getDetail().getType();
        this.brand = newProd.getDetail().getBrand();
        this.color = newProd.getDetail().getColor();
        this.notes = newProd.getDetail().getNotes();
        this.type = newProd.getDetail().getType();
        this.price = newProd.getPrice();
        this.category = newProd.getCategory();
        this.hasPromo = true;
        this.discount = newProd.getDiscount();
        
    }

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
    public double getDiscount() {
        return discount;
    }public void setDiscount(double discount) {
        this.discount = discount;
    }
    public boolean getHasPromo(){
        return this.hasPromo;
    }
}
