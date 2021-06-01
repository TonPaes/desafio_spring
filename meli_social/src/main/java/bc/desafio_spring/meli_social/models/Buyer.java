package bc.desafio_spring.meli_social.models;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @ManyToMany
    @JoinTable(
        name = "following",
        joinColumns = @JoinColumn(name = "seller_id"),
        inverseJoinColumns = @JoinColumn(name = "buyer_id") )
    Set<Seller> sellerSet;


    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}
  
