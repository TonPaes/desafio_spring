package bc.desafio_spring.meli_social.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bc.desafio_spring.meli_social.dto.*;
import bc.desafio_spring.meli_social.services.BuyerService;

@RestController
@RequestMapping("buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService = new BuyerService();

	@PostMapping("/")
	public ResponseEntity<String> createBuyer(@RequestBody CreateBuyerRequestDTO createBuyerRequestDTO){
		return ResponseEntity.status(201).body("User created with ID: " +
											   buyerService.createBuyer(createBuyerRequestDTO)
		);
	}

    @PostMapping("{idBuyer}/follow")
    public ResponseEntity<String > follow(
                                    @RequestBody FollowRequestDTO followResquestDTO, 
                                    @PathVariable UUID idBuyer) {
        if (buyerService.follow(followResquestDTO, idBuyer))
            return ResponseEntity.status(201).body("follow added");
		else
			return ResponseEntity.status(400).body("did not followed");
	}
    
	

}
