package bc.desafio_spring.meli_social.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bc.desafio_spring.meli_social.dto.NewPromoProductRequestDTO;
import bc.desafio_spring.meli_social.dto.NewproductRequestDTO;
import bc.desafio_spring.meli_social.dto.ProductListResponseDTO;
import bc.desafio_spring.meli_social.dto.PromProductListResponseDTO;
import bc.desafio_spring.meli_social.dto.PromProductsCountResponseDTO;
import bc.desafio_spring.meli_social.models.Buyer;
import bc.desafio_spring.meli_social.models.Product;
import bc.desafio_spring.meli_social.models.PromProduct;
import bc.desafio_spring.meli_social.models.Seller;
import bc.desafio_spring.meli_social.repositories.BuyerRepository;
import bc.desafio_spring.meli_social.repositories.SellerRepository;

@Service
public class ProductServiceImpl  implements ProductService{
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

    public void newPromoPost(NewPromoProductRequestDTO newPromProd){
        Optional<Seller> optSeller = sellerRepository.findById(newPromProd.getUserId());
        Seller seller = optSeller.get();

        PromProduct prod = new PromProduct(newPromProd); 

        seller.getPromProducts().add(prod);
        sellerRepository.save(seller);
    }

    public PromProductsCountResponseDTO promProdCount(UUID sellerId){
        Optional<Seller> optSeller = sellerRepository.findById(sellerId);
        Seller seller = optSeller.get();

        PromProductsCountResponseDTO ppCount = new PromProductsCountResponseDTO();

        ppCount.setUserID(seller.getId());
        ppCount.setPromoProductsCount(seller.getPromProducts().size());
        ppCount.setUserName(seller.getName());

        return ppCount;
    }

    public PromProductListResponseDTO listFollowedPromProducts(UUID userId){
        Optional<Seller> optSeller = sellerRepository.findById(userId);
        Seller user = optSeller.get();

        PromProductListResponseDTO response = new PromProductListResponseDTO();

        response.setUserId(user.getId());

        for (PromProduct product : user.getPromProducts()) {
            response.getProducts().add(new NewPromoProductRequestDTO(product));
        }
        
        return response;
    }
}
