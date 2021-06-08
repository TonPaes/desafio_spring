package bc.desafio_spring.meli_social.services;

import java.util.UUID;

import bc.desafio_spring.meli_social.dto.CreateBuyerRequestDTO;
import bc.desafio_spring.meli_social.dto.FollowersCountResponseDTO;
import bc.desafio_spring.meli_social.dto.FollowersListResponseDTO;
import bc.desafio_spring.meli_social.dto.FollowingListResponseDTO;
import bc.desafio_spring.meli_social.exceptions.CannotFollowBuyerException;

public interface UserService {
    public boolean follow(UUID idFollower, UUID idSeeller) throws CannotFollowBuyerException;
    public UUID createBuyer(CreateBuyerRequestDTO createBuyerRequestDTO);
    public UUID createSeller(CreateBuyerRequestDTO createBuyerRequestDTO);
    public FollowersCountResponseDTO countFollowers(UUID sellerID);
    public FollowersListResponseDTO listFollowers(UUID sellerId, String order);
    public FollowingListResponseDTO listFollowing(UUID buyerID, String order);
    public boolean unfollow(UUID idFollower, UUID idSeller);
}
