package bc.desafio_spring.meli_social.dto;

import java.util.Date;
import java.util.UUID;

public class NewproductRequestDTO {
    private UUID userId;
    private UUID postId;
    private Date date;
    private ProductDetailDTO detail;
    private String category;
    private Double price;

    public String getCategory() {
        return category;
    }
    public Date getDate() {
        return date;
    }
    public ProductDetailDTO getDetail() {
        return detail;
    }
    public UUID getPostId() {
        return postId;
    }
    public Double getPrice() {
        return price;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setDetail(ProductDetailDTO detail) {
        this.detail = detail;
    }
    public void setPostId(UUID postId) {
        this.postId = postId;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
