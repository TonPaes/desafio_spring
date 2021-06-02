package bc.desafio_spring.meli_social.dto;

import java.util.List;
import java.util.UUID;

import bc.desafio_spring.meli_social.models.Buyer;

public class FollowersListResponseDTO {
    private UUID userId;
    private String userName;
    private List<Buyer> followers;
    
    public FollowersListResponseDTO(
        UUID userId,
        String userName,
        List<Buyer> followers
    ){
        this.userId = userId;
        this.followers = followers;
        this.userName = userName;
    }

    public UUID getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public List<Buyer> getFollowers() {
        return followers;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void setFollowers(List<Buyer> followers) {
        this.followers = followers;
    }

}
