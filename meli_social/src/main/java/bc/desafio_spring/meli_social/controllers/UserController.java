package bc.desafio_spring.meli_social.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import bc.desafio_spring.meli_social.dto.*;
import bc.desafio_spring.meli_social.services.BuyerService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    BuyerService buyerService = new BuyerService();

	@PostMapping("/")
	public ResponseEntity<String> createBuyer(@RequestBody CreateBuyerRequestDTO createBuyerRequestDTO){
		return ResponseEntity.status(201).body("User created with ID: " +
											   buyerService.createSeller(createBuyerRequestDTO)
		);
	}

    @PostMapping("{userId}/follow/{sellerUserId}")
    public ResponseEntity<String > follow(
									@PathVariable UUID userId, 
                                    @PathVariable UUID sellerUserId) {
        if (buyerService.follow(sellerUserId, userId))
            return ResponseEntity.status(200).body("follow added");
		else
			return ResponseEntity.status(400).body("did not followed");
	}

	@GetMapping("{userId}/followers/count")
	public ResponseEntity<FollowersCountResponseDTO> followerCount(@PathVariable UUID userId){
		return ResponseEntity.status(200).body(buyerService.countFollowers(userId));
	}

	@GetMapping("{userId}/followers/list")
	public ResponseEntity<FollowersListResponseDTO> followerList(@PathVariable UUID userId){
		return ResponseEntity.status(200).body(buyerService.listFollowers(userId));
	}
	@GetMapping("{userId}/followed/list")
	public ResponseEntity<FollowingListResponseDTO> followingList(@PathVariable UUID userId){
		return ResponseEntity.status(200).body(buyerService.listFollowing(userId));
	}
}
