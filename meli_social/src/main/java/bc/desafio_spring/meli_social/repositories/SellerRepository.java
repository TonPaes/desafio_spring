package bc.desafio_spring.meli_social.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bc.desafio_spring.meli_social.models.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller, UUID> {
    
}

