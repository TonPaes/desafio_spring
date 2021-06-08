package bc.desafio_spring.meli_social.services;

import java.util.UUID;

import bc.desafio_spring.meli_social.dto.NewPromoProductRequestDTO;
import bc.desafio_spring.meli_social.dto.NewproductRequestDTO;
import bc.desafio_spring.meli_social.dto.ProductListResponseDTO;
import bc.desafio_spring.meli_social.dto.PromProductListResponseDTO;
import bc.desafio_spring.meli_social.dto.PromProductsCountResponseDTO;

public interface ProductService {
    public void createNewProduct(NewproductRequestDTO newProd);
    public ProductListResponseDTO listFollowedProducts(UUID userId, String order);
    public void newPromoPost(NewPromoProductRequestDTO newPromPost);
    public PromProductsCountResponseDTO promProdCount(UUID userId);
    public PromProductListResponseDTO listFollowedPromProducts(UUID userId);
}
