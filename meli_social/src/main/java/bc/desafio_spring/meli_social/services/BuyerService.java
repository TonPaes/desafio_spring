package bc.desafio_spring.meli_social.services;

import org.springframework.stereotype.Service;

import bc.desafio_spring.meli_social.dto.FollowResquestDTO;
import bc.desafio_spring.meli_social.repositories.BuyerRepository;


@Service
public class BuyerService {
    private BuyerRepository buyerRepository;
    
    public boolean follow(FollowResquestDTO followResquestDTO){
        
        return false;
    }
}
