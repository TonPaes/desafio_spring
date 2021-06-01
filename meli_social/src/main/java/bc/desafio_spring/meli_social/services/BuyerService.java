package bc.desafio_spring.meli_social.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bc.desafio_spring.meli_social.dto.CreateBuyerRequestDTO;
import bc.desafio_spring.meli_social.dto.FollowRequestDTO;
import bc.desafio_spring.meli_social.models.Buyer;
import bc.desafio_spring.meli_social.models.Seller;
import bc.desafio_spring.meli_social.repositories.BuyerRepository;
import bc.desafio_spring.meli_social.repositories.SellerRepository;


@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public boolean follow(FollowRequestDTO followResquestDTO, UUID idBuyer){
        Optional<Seller> optSeller = sellerRepository.findById(followResquestDTO.getIdSeller());
        Seller seller = optSeller.get();
        
        Optional<Buyer> optBuyer = buyerRepository.findById(idBuyer);
        Buyer buyer = optBuyer.get();
        
        buyer.getSellerSet().add(seller);
        seller.getBuyerSet().add(buyer);
        
        buyerRepository.save(buyer);
        sellerRepository.save(seller);

        return false;
    }
    public UUID createBuyer(CreateBuyerRequestDTO createBuyerRequestDTO){
        Buyer buyer = new Buyer();
        
        buyer.setName(createBuyerRequestDTO.getName());
        return buyerRepository.save(buyer).getId();
    }
}
