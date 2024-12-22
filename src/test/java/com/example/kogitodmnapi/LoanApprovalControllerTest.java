package com.example.kogitodmnapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoanApprovalControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testLoanApprovalApproved() {
        Map<String, Object> request = new HashMap<>();
        request.put("Age", 25);
        request.put("CreditScore", 750);

        ResponseEntity<Map> response = restTemplate.postForEntity("/loan-approval", request, Map.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(true, response.getBody().get("LoanApproval"));
    }

    @Test
    public void testLoanApprovalDeniedDueToAge() {
        Map<String, Object> request = new HashMap<>();
        request.put("Age", 17);
        request.put("CreditScore", 750);

        ResponseEntity<Map> response = restTemplate.postForEntity("/loan-approval", request, Map.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(false, response.getBody().get("LoanApproval"));
    }

    @Test
    public void testLoanApprovalDeniedDueToCreditScore() {
        Map<String, Object> request = new HashMap<>();
        request.put("Age", 25);
        request.put("CreditScore", 650);

        ResponseEntity<Map> response = restTemplate.postForEntity("/loan-approval", request, Map.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(false, response.getBody().get("LoanApproval"));
    }
}

