package bc.desafio_spring.meli_social.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bc.desafio_spring.meli_social.dto.NewproductRequestDTO;
import bc.desafio_spring.meli_social.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService = new ProductService();

    @PostMapping("/newpost")
    public ResponseEntity<String> newPost(@RequestBody NewproductRequestDTO newPost){
        return ResponseEntity.status(200).body("Tudo ok");
    }

    
}
