package bc.desafio_spring.meli_social.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

import bc.desafio_spring.meli_social.dto.*;
import bc.desafio_spring.meli_social.services.UserServiceImpl;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
	UserService userService = new UserServiceImpl();
	
	@PostMapping("/")
	public ResponseEntity<String> createBuyer(@RequestBody CreateBuyerRequestDTO createBuyerRequestDTO){
		return ResponseEntity.status(201).body("User created with ID: " +
											   userService.createSeller(createBuyerRequestDTO)
		);
	}

    @PostMapping("{userId}/follow/{sellerUserId}")
    public ResponseEntity<String > follow(
										  @PathVariable UUID userId, 
                                          @PathVariable UUID sellerUserId) {
        if (userService.follow(sellerUserId, userId))
            return ResponseEntity.status(200).body("follow added");
		else
			return ResponseEntity.status(400).body("did not followed");
	}

	@GetMapping("{userId}/followers/count")
	public ResponseEntity<FollowersCountResponseDTO> followerCount(@PathVariable UUID userId){
		return ResponseEntity.status(200).body(userService.countFollowers(userId));
	}

	@GetMapping("{userId}/followers/list")
	public ResponseEntity<FollowersListResponseDTO> followerList(
				@PathVariable UUID userId,
				@RequestParam String order)
		{
		return ResponseEntity.status(200).body(userService.listFollowers(userId, order));
	}
	@GetMapping("{userId}/followed/list")
	public ResponseEntity<FollowingListResponseDTO> followingList(
				@PathVariable UUID userId,
				@RequestParam String order)
		{
		return ResponseEntity.status(200).body(userService.listFollowing(userId, order));
	}
	@PostMapping("{userId}/unfollow/{sellerUserId}")
    public ResponseEntity<String > unfollow(
											@PathVariable UUID userId, 
                                    		@PathVariable UUID sellerUserId)
		{
    	userService.unfollow(userId, sellerUserId);							
		return ResponseEntity.status(200).body("");
	}
}