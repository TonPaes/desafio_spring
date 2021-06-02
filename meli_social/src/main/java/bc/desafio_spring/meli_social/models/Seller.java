package bc.desafio_spring.meli_social.models;

import java.util.HashSet;
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
    private String name;

    @ManyToMany(targetEntity = Buyer.class)
    Set<Buyer> buyerSet = new HashSet<>();
    
   public UUID getId() {
       return id;
   }

    public Set<Buyer> getBuyerSet() {
        return buyerSet;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
