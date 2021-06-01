package bc.desafio_spring.meli_social.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import bc.desafio_spring.meli_social.models.Seller;

public interface SellerRepository extends CrudRepository<Seller, UUID> {
    
}

