package bc.desafio_spring.meli_social.services;

import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bc.desafio_spring.meli_social.dto.CreateBuyerRequestDTO;
import bc.desafio_spring.meli_social.dto.FollowersCountResponseDTO;
import bc.desafio_spring.meli_social.dto.FollowersListResponseDTO;
import bc.desafio_spring.meli_social.dto.FollowingListResponseDTO;
import bc.desafio_spring.meli_social.exceptions.CannotFollowBuyerException;
import bc.desafio_spring.meli_social.models.Buyer;
import bc.desafio_spring.meli_social.models.Seller;
import bc.desafio_spring.meli_social.repositories.BuyerRepository;
import bc.desafio_spring.meli_social.repositories.SellerRepository;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public boolean follow(UUID idFollower, UUID idSeller){
        Buyer follower;
        Optional<Buyer> optFollower = buyerRepository.findById(idFollower);
        
        if(!optFollower.isEmpty()){
            follower = optFollower.get();

        }else{
            Optional<Seller> followeOptional = sellerRepository.findById(idFollower);
            Seller Sfollower = followeOptional.get();
            Optional<Buyer> optBuyerfollower =  buyerRepository.findById(Sfollower.getBuyerUserId());
            follower = optBuyerfollower.get();
        }
        

        Optional<Seller> optSeller = sellerRepository.findById(idSeller);

        if(!optFollower.isEmpty())
            throw new CannotFollowBuyerException(idSeller);

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

        seller.setBuyerUserId( createBuyer(createBuyerRequestDTO));
        
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
    public FollowersListResponseDTO listFollowers(UUID sellerId, String order){
        Optional<Seller> optSeller = sellerRepository.findById(sellerId);
        Seller seller = optSeller.get();

        List<Buyer> followersList = new ArrayList<>(seller.getBuyerSet());
        for (Buyer buyer : followersList) {
            buyer.setSellerSet(null);
        }

        if (order.equals("asc"))
            followersList.sort((f1, f2)-> f1.getName().compareTo(f2.getName()));
        else if(order.equals("desc"))
            followersList.sort((f2, f1)-> f1.getName().compareTo(f2.getName()));        

        return new FollowersListResponseDTO(
            sellerId,
            seller.getName(),
            followersList
        );

    }

    public FollowingListResponseDTO listFollowing(UUID buyerId, String order){
        Optional<Buyer> optBuyer = buyerRepository.findById(buyerId);
        Buyer buyer = optBuyer.get();

        List<Seller> followingList = new ArrayList<>(buyer.getSellerSet());
        for (Seller seller : followingList) {
            seller.setBuyerSet(null);
        }

        if (order.equals("asc"))
            followingList.sort((f1, f2)-> f1.getName().compareTo(f2.getName()));
        else if(order.equals("desc"))
           followingList.sort((f2, f1)-> f1.getName().compareTo(f2.getName()));

        return new FollowingListResponseDTO(
            buyerId,
            buyer.getName(),
            followingList
        );

    }
    public boolean unfollow(UUID idFollower, UUID idSeller){
        Buyer follower = new Buyer();
        Optional<Buyer> optFollower = buyerRepository.findById(idFollower);
        
        follower = optFollower.get();

        Optional<Seller> optSeller = sellerRepository.findById(idSeller);
        Seller seller = optSeller.get();

        seller.getBuyerSet().remove(follower);
        follower.getSellerSet().remove(seller);

        buyerRepository.save(follower);
        sellerRepository.save(seller);

        return true;
    }
}
