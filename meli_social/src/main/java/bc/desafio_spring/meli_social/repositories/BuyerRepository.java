package bc.desafio_spring.meli_social.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bc.desafio_spring.meli_social.models.Buyer;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, UUID> {
    
}

