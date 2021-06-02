package bc.desafio_spring.meli_social.services;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bc.desafio_spring.meli_social.dto.CreateBuyerRequestDTO;
import bc.desafio_spring.meli_social.dto.FollowersCountResponseDTO;
import bc.desafio_spring.meli_social.dto.FollowersListResponseDTO;
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

    public boolean follow(UUID idFollower, UUID idSeller){
        Buyer follower = new Buyer();
        Optional<Buyer> optFollower = buyerRepository.findById(idFollower);
        
        if(!optFollower.isEmpty()){
            follower = optFollower.get();

        }else{
            Optional<Seller> followeOptional = sellerRepository.findById(idFollower);
            Seller Sfollower = followeOptional.get();
            follower.setName(Sfollower.getName());
        }
        

        Optional<Seller> optSeller = sellerRepository.findById(idSeller);
        Seller seller = optSeller.get();

        seller.getBuyerSet().add(follower);
        follower.getSellerSet().add(seller);

        buyerRepository.save(follower);
        sellerRepository.save(seller);

        return true;
    }
    public UUID createBuyer(CreateBuyerRequestDTO createBuyerRequestDTO){
        Buyer buyer = new Buyer();
        
        buyer.setName(createBuyerRequestDTO.getName());
        return buyerRepository.save(buyer).getId();
    }

    public UUID createSeller(CreateBuyerRequestDTO createBuyerRequestDTO){
        Seller seller = new Seller();
        
        seller.setName(createBuyerRequestDTO.getName());
        return sellerRepository.save(seller).getId();
    }

    public FollowersCountResponseDTO countFollowers(UUID sellerId){
        Optional<Seller> optSeller = sellerRepository.findById(sellerId);
        Seller seller = optSeller.get();

        int toCount = seller.getBuyerSet().size();


        return  new FollowersCountResponseDTO(
                                             sellerId,
                                             seller.getName(),
                                             toCount);
    }
    public FollowersListResponseDTO listFollowers(UUID sellerId){
        Optional<Seller> optSeller = sellerRepository.findById(sellerId);
        Seller seller = optSeller.get();

        List<Buyer> followersList = new ArrayList<>(seller.getBuyerSet());
        for (Buyer buyer : followersList) {
            buyer.setSellerSet(null);
        }
        return new FollowersListResponseDTO(
            sellerId,
            seller.getName(),
            followersList
        );

    }

}
