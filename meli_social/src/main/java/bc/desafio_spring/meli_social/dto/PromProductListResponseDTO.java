package bc.desafio_spring.meli_social.dto;

import java.util.List;
import java.util.UUID;

public class PromProductListResponseDTO {
    private UUID userId;
    private String userName;
    private List<NewPromoProductRequestDTO> products;

    public List<NewPromoProductRequestDTO> getProducts() {
        return products;
    }
    public UUID getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setProducts(List<NewPromoProductRequestDTO> products) {
        this.products = products;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
