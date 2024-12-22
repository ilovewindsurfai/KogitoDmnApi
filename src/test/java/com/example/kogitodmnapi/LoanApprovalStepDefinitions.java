package com.example.kogitodmnapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoanApprovalStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    private Map<String, Object> request;
    private ResponseEntity<Map> response;

    @Given("an applicant is {int} years old")
    public void anApplicantIsYearsOld(int age) {
        request = new HashMap<>();
        request.put("Age", age);
    }

    @Given("the applicant has a credit score of {int}")
    public void theApplicantHasACreditScoreOf(int creditScore) {
        request.put("CreditScore", creditScore);
    }

    @When("the loan approval is checked")
    public void theLoanApprovalIsChecked() {
        response = restTemplate.postForEntity("/loan-approval", request, Map.class);
    }

    @Then("the loan should be approved")
    public void theLoanShouldBeApproved() {
        assertEquals(true, response.getBody().get("LoanApproval"));
    }

    @Then("the loan should be denied")
    public void theLoanShouldBeDenied() {
        assertEquals(false, response.getBody().get("LoanApproval"));
    }
}

