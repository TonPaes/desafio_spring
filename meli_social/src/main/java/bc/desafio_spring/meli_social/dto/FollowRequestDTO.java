package bc.desafio_spring.meli_social.dto;

import java.util.UUID;

public class FollowRequestDTO {
    private UUID idSeller;
    
    public UUID getIdSeller() {
        return idSeller;
    }
    public void setIdSeller(UUID idSeller) {
        this.idSeller = idSeller;
    }
}
