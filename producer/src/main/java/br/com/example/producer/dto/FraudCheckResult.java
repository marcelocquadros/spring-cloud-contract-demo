package br.com.example.producer.dto;

import br.com.example.producer.domain.FraudCheckStatus;

public class FraudCheckResult {

    private FraudCheckStatus fraudCheckStatus;
    private String rejectionReason;

    public FraudCheckResult(FraudCheckStatus fraudCheckStatus, String rejectionReason) {
        this.fraudCheckStatus = fraudCheckStatus;
        this.rejectionReason = rejectionReason;
    }

    public FraudCheckResult(){}

    public FraudCheckStatus getFraudCheckStatus() {
        return fraudCheckStatus;
    }

    public void setFraudCheckStatus(FraudCheckStatus fraudCheckStatus) {
        this.fraudCheckStatus = fraudCheckStatus;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}

