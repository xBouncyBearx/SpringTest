package com.example.springtest.DTO;

import com.example.springtest.Entity.Enum.TransactionStatus;
import com.example.springtest.Entity.Enum.TransactionType;


public class TransactionRequest {

    private TransactionType transactionType;
    private String from;
    private String to;
    private Double amount;

    public TransactionRequest(TransactionType transactionType, String from, String to, Double amount) {
        this.transactionType = transactionType;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public TransactionRequest() {
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
