package bc.desafio_spring.meli_social.dto;

import java.util.List;
import java.util.UUID;

public class ProductListResponseDTO {
    private UUID userId;
    private List<NewproductRequestDTO> products;



    public List<NewproductRequestDTO> getProducts() {
        return products;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setProducts(List<NewproductRequestDTO> products) {
        this.products = products;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void addProducts(NewproductRequestDTO prod){
        this.products.add(prod);
    }

}
