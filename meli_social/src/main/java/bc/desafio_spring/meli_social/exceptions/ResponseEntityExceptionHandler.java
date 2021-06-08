package bc.desafio_spring.meli_social.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ResponseEntityExceptionHandler {
    @ExceptionHandler(CannotFollowBuyerException.class)
    protected ResponseEntity<String> handleCannotFollowBuyerException(CannotFollowBuyerException e){
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
