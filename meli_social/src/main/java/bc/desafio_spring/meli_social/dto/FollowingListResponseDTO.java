package bc.desafio_spring.meli_social.dto;

import java.util.UUID;
import java.util.List;
import bc.desafio_spring.meli_social.models.Seller;

public class FollowingListResponseDTO {
    private UUID userId;
    private String userName;
    private List<Seller> followed;
    
    public FollowingListResponseDTO(
        UUID userId,
        String userName,
        List<Seller> followed
    ){
        this.userId = userId;
        this.followed = followed;
        this.userName = userName;
    }

    public UUID getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public List<Seller> getFollowers() {
        return followed;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void setFollowers(List<Seller> followers) {
        this.followed = followers;
    }
}
