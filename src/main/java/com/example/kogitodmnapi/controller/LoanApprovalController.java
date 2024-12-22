package com.example.kogitodmnapi.controller;

import com.example.kogitodmnapi.dto.LoanRequest;
import com.example.kogitodmnapi.dto.LoanResponse;
import com.example.kogitodmnapi.service.LoanApprovalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LoanApprovalController {

    private final LoanApprovalService loanApprovalService;

    public LoanApprovalController(LoanApprovalService loanApprovalService) {
        this.loanApprovalService = loanApprovalService;
    }

    @PostMapping("/loan-approval")
    public ResponseEntity<LoanResponse> checkLoanApproval(@RequestBody LoanRequest request) {
        LoanResponse response = loanApprovalService.evaluateLoanApproval(request);
        return ResponseEntity.ok(response);
    }
}

