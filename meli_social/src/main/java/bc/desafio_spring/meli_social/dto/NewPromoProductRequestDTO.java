package bc.desafio_spring.meli_social.dto;

import java.util.Date;
import java.util.UUID;

import bc.desafio_spring.meli_social.models.Product;
import bc.desafio_spring.meli_social.models.PromProduct;

public class NewPromoProductRequestDTO {
    private UUID userId;
    private UUID postId;
    private Date date;
    private ProductDetailDTO detail;
    private int category;
    private Double price;
    private boolean hasPromo;
    private Double discount;

    public NewPromoProductRequestDTO(
        PromProduct newProd
    ){
        this.postId = newProd.getId();
        this.userId = newProd.getSeller().getId();
        this.date = newProd.getDate();
        this.detail.setProductName(newProd.getProductName());
        this.detail.setType(newProd.getType());
        this.detail.setBrand(newProd.getBrand());
        this.detail.setColor(newProd.getColor());
        this.detail.setNotes(newProd.getNotes());
        this.detail.setType(newProd.getType());
    }

    public int getCategory() {
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
    public void setCategory(int category) {
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
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public Double getDiscount() {
        return discount;
    }
    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }
    public boolean getHasPromo(){
        return this.hasPromo;
    }

}
