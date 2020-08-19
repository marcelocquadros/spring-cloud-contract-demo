package br.com.example.producer.dto;

import br.com.example.producer.domain.FraudCheckStatus;
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
