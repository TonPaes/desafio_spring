package bc.desafio_spring.meli_social.models;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Seller {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany(targetEntity = Buyer.class)
    Set<Buyer> buyerSet;
    
   public UUID getId() {
       return id;
   }

    public Set<Buyer> getBuyerSet() {
        return buyerSet;
    }   
}
