package br.com.sample.consumer.dto;


import br.com.sample.consumer.domain.FraudCheckStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckResult {
    private FraudCheckStatus fraudCheckStatus;
    private String rejectionReason;
}

