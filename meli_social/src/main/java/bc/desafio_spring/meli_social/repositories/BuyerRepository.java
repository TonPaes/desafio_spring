package bc.desafio_spring.meli_social.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import bc.desafio_spring.meli_social.models.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer, UUID> {
    
}

