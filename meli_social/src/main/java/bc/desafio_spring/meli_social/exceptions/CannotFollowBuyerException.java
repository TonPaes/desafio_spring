package bc.desafio_spring.meli_social.exceptions;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CannotFollowBuyerException extends ResponseStatusException {
    public CannotFollowBuyerException(UUID follower){
        super(HttpStatus.BAD_REQUEST, String.format("User %s is a buyer and cannot be followed", 
                                                    follower
        ));
    }
}
