package bc.desafio_spring.meli_social.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bc.desafio_spring.meli_social.dto.NewproductRequestDTO;
import bc.desafio_spring.meli_social.dto.ProductListResponseDTO;
import bc.desafio_spring.meli_social.models.Buyer;
import bc.desafio_spring.meli_social.models.Product;
import bc.desafio_spring.meli_social.models.Seller;
import bc.desafio_spring.meli_social.repositories.BuyerRepository;
import bc.desafio_spring.meli_social.repositories.SellerRepository;

@Service
public class ProductService {
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public void createNewProduct(NewproductRequestDTO newProd){
        Optional<Seller> optSeller = sellerRepository.findById(newProd.getUserId());
        Seller seller = optSeller.get();

        Product prod = new Product(newProd); 

        seller.getProducts().add(prod);
        sellerRepository.save(seller);
    }

    public ProductListResponseDTO listFollowedProducts(UUID userId, String order){
        Optional<Buyer> optBuyer = buyerRepository.findById(userId);
        Buyer user = optBuyer.get();

        ProductListResponseDTO response = new ProductListResponseDTO();

        response.setUserId(user.getId());

        for (Seller followedSeller : user.getSellerSet()) {
            for (Product product : followedSeller.getProducts()) {
                response.addProducts(new NewproductRequestDTO(product));
            }
        }
        if (order.equals("asc"))
            response.getProducts().sort(
                (p1, p2) -> p1.getDate().compareTo(p2.getDate())
        );
        else
            response.getProducts().sort(
                (p2, p1) -> p1.getDate().compareTo(p2.getDate())
            );
        
        return response;
    }
}
