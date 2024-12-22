package com.example.kogitodmnapi.dto;

public class LoanResponse {
    private boolean approved;
    private String message;

    public LoanResponse(boolean approved, String message) {
        this.approved = approved;
        this.message = message;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

