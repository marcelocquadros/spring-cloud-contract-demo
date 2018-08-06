package br.com.example.producer.controllers;

public class PaymentStatus {

    public PaymentStatus(Boolean approved) {
        this.approved = approved;
    }

    private Boolean approved;

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}