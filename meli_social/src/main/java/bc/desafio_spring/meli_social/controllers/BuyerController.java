package bc.desafio_spring.meli_social.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bc.desafio_spring.meli_social.dto.*;

@RestController
@RequestMapping("/")
public class BuyerController {
    @PostMapping("{idBuyer}/follow")
    public ResponseEntity<String> follow(@RequestBody FollowResquestDTO followResquestDTO ) {
        // TODO: call service to register a new follower on a buyer
        
        return ResponseEntity.status(201).body("placeHolder");
    }
    

}
