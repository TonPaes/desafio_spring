package bc.desafio_spring.meli_social.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bc.desafio_spring.meli_social.dto.NewPromoProductRequestDTO;
import bc.desafio_spring.meli_social.dto.NewproductRequestDTO;
import bc.desafio_spring.meli_social.dto.ProductListResponseDTO;
import bc.desafio_spring.meli_social.dto.PromProductListResponseDTO;
import bc.desafio_spring.meli_social.dto.PromProductsCountResponseDTO;
import bc.desafio_spring.meli_social.services.ProductService;
import bc.desafio_spring.meli_social.services.ProductServiceImpl;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService = new ProductServiceImpl();

    @PostMapping("/newpost")
    public ResponseEntity<String> newPost(@RequestBody NewproductRequestDTO newPost){
        productService.createNewProduct(newPost);
        return ResponseEntity.status(200).body("");
    }

    @GetMapping("followed/{userId}/list")
    public ResponseEntity<ProductListResponseDTO> listProducts(
                @PathVariable UUID userId,
                @RequestParam String order)
    {
        return ResponseEntity.status(200).body(productService.listFollowedProducts(
                userId, order));
    }
    @PostMapping("/newpromopost")
    public ResponseEntity<String> newPromoPost(@RequestBody NewPromoProductRequestDTO newProm){
        productService.newPromoPost(newProm);
        return ResponseEntity.status(200).body("");
    }
    @GetMapping("{userId}/countPromo")
    public ResponseEntity<PromProductsCountResponseDTO> countPromProducts(@PathVariable UUID userId){
        return ResponseEntity.status(200).body( productService.promProdCount(userId));
    }
    @GetMapping("/products/{userId}/list")
    public ResponseEntity<PromProductListResponseDTO> listPromProducts(@PathVariable UUID userId){
        return ResponseEntity.status(200).body(productService.listFollowedPromProducts(userId));
    }
}
