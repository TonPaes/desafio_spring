package bc.desafio_spring.meli_social.dto;

import java.lang.reflect.Constructor;
import java.util.UUID;

public class FollowersCountResponseDTO {
    private UUID userId;
    private String name;
    private int followers_count;

    public FollowersCountResponseDTO(UUID userId, String name, int followers_count){
        this.userId = userId;
        this.name = name;
        this.followers_count =followers_count;
    }

    public String getName() {
        return name;
    }
    public int getFollowers_count() {
        return followers_count;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
