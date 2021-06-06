package bc.desafio_spring.meli_social.dto;

import java.util.Set;
import java.util.UUID;

public class ProductDetailDTO {
    private UUID productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }
    public String getNotes() {
        return notes;
    }
    public UUID getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public String getType() {
        return type;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setColor(String color) {
        this.color = color;
    }public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setProductId(UUID productId) {
        this.productId = productId;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
}
