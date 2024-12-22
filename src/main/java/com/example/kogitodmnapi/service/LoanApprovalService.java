package com.example.kogitodmnapi.service;

import com.example.kogitodmnapi.dto.LoanRequest;
import com.example.kogitodmnapi.dto.LoanResponse;

public interface LoanApprovalService {
    LoanResponse evaluateLoanApproval(LoanRequest request);
}

