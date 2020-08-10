package br.com.example.producer.controllers;

import br.com.example.producer.domain.FraudCheckStatus;
import br.com.example.producer.dto.FraudCheckRequest;
import br.com.example.producer.dto.FraudCheckResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class FraudDetectionController {

    private static final String NO_REASON = null;
    private static final String AMOUNT_TOO_HIGH = "Amount too high";
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("10000");

    @PostMapping("/fraudcheck")
    public FraudCheckResult fraudCheck(@RequestBody FraudCheckRequest request) {

        if (amountGreaterThanThreshold(request.getTotalAmount())) {
            return new FraudCheckResult(FraudCheckStatus.FRAUD, AMOUNT_TOO_HIGH);
        }

        return new FraudCheckResult(FraudCheckStatus.OK, NO_REASON);

    }

    private boolean amountGreaterThanThreshold(BigDecimal totalAmount) {
        return MAX_AMOUNT.compareTo(totalAmount) < 0;
    }

}
