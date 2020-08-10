package br.com.sample.consumer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FraudCheckRequest {

    private String customerId;

    private BigDecimal totalAmount;

}
