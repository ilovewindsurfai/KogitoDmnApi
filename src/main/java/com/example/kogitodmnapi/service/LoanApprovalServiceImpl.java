package com.example.kogitodmnapi.service;

import com.example.kogitodmnapi.dto.LoanRequest;
import com.example.kogitodmnapi.dto.LoanResponse;
import org.kie.kogito.decision.DecisionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoanApprovalServiceImpl implements LoanApprovalService {
    
    private static final Logger logger = LoggerFactory.getLogger(LoanApprovalServiceImpl.class);
    private final DecisionModel loanApprovalModel;

    public LoanApprovalServiceImpl(DecisionModel loanApprovalModel) {
        this.loanApprovalModel = loanApprovalModel;
    }

    @Override
    public LoanResponse evaluateLoanApproval(LoanRequest request) {
        try {
            logger.info("Evaluating loan approval for age: {} and credit score: {}", 
                request.getAge(), request.getCreditScore());

            Map<String, Object> inputs = new HashMap<>();
            inputs.put("Age", request.getAge());
            inputs.put("CreditScore", request.getCreditScore());

            Map<String, Object> result = loanApprovalModel.evaluateAll(
                loanApprovalModel.newContext(inputs)
            );

            boolean approved = (boolean) result.get("LoanApproval");
            String message = generateResponseMessage(approved, request);

            logger.info("Loan approval decision: {}", approved);
            return new LoanResponse(approved, message);

        } catch (Exception e) {
            logger.error("Error evaluating loan approval", e);
            throw new RuntimeException("Failed to process loan approval", e);
        }
    }

    private String generateResponseMessage(boolean approved, LoanRequest request) {
        if (approved) {
            return "Loan approved based on age: " + request.getAge() + 
                   " and credit score: " + request.getCreditScore();
        } else {
            if (request.getAge() < 18) {
                return "Loan denied: Applicant must be 18 or older";
            } else if (request.getCreditScore() < 700) {
                return "Loan denied: Credit score must be 700 or higher";
            }
            return "Loan denied based on provided criteria";
        }
    }
}

