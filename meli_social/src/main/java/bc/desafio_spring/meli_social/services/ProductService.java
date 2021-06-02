package bc.desafio_spring.meli_social.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bc.desafio_spring.meli_social.dto.NewproductRequestDTO;
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

        seller.getProducts().add(e);
    }
}
