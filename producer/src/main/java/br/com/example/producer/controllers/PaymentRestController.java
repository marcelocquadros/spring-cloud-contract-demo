package br.com.example.producer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PaymentRestController {

    @GetMapping(value="v1/payments/{id}/status", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentStatus> getPaymentStatus(@PathVariable Integer id) {

        if (id > 40) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body(new PaymentStatus(false));
        } else {
            return ResponseEntity.ok(new PaymentStatus(true));
        }
    }
}
