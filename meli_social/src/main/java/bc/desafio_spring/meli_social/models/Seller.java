package bc.desafio_spring.meli_social.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Seller {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;
    private String name;

    @ManyToMany(targetEntity = Buyer.class)
    Set<Buyer> buyerSet = new HashSet<>();
    
    @OneToMany(targetEntity = Product.class)
    Set<Product> products = new HashSet<>();

    @OneToMany(targetEntity = PromProduct.class)
    Set<PromProduct> promProducts = new HashSet<>();

    
    private UUID buyerUserId;

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
    public void setBuyerSet(Set<Buyer> buyerSet) {
        this.buyerSet = buyerSet;
    }

    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
    public void setPromProducts(Set<PromProduct> promProducts) {
        this.promProducts = promProducts;
    }
    public Set<PromProduct> getPromProducts() {
        return promProducts;
    }
    public UUID getBuyerUserId() {
        return buyerUserId;
    }
    public void setBuyerUserId(UUID buyerUserId) {
        this.buyerUserId = buyerUserId;
    }
}
