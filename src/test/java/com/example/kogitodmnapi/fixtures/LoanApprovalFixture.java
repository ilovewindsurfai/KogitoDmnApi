package com.example.kogitodmnapi.fixtures;

import com.example.kogitodmnapi.dto.LoanRequest;
import com.example.kogitodmnapi.dto.LoanResponse;
import com.example.kogitodmnapi.service.LoanApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanApprovalFixture {
    private final LoanApprovalService loanApprovalService;
    private int age;
    private int creditScore;
    private boolean approved;
    private String message;

    @Autowired
    public LoanApprovalFixture(LoanApprovalService loanApprovalService) {
        this.loanApprovalService = loanApprovalService;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void checkApproval() {
        LoanRequest request = new LoanRequest();
        request.setAge(age);
        request.setCreditScore(creditScore);

        LoanResponse response = loanApprovalService.evaluateLoanApproval(request);
        this.approved = response.isApproved();
        this.message = response.getMessage();
    }

    public boolean approved() {
        return approved;
    }

    public String message() {
        return message;
    }
}

