package br.com.example.producer.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class FraudCheckRequest {

    private String customerId;

    private BigDecimal totalAmount;

}
