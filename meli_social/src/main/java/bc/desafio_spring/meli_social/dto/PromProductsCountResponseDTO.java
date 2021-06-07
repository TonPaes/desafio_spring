package bc.desafio_spring.meli_social.dto;

import java.util.UUID;

public class PromProductsCountResponseDTO {
    private UUID userID;
    private String userName;
    private int promoProductsCount;
    
    public int getPromoProductsCount() {
        return promoProductsCount;
    }public UUID getUserID() {
        return userID;
    }public String getUserName() {
        return userName;
    }public void setPromoProductsCount(int promoProductsCount) {
        this.promoProductsCount = promoProductsCount;
    }public void setUserID(UUID userID) {
        this.userID = userID;
    }public void setUserName(String userName) {
        this.userName = userName;
    }
}
