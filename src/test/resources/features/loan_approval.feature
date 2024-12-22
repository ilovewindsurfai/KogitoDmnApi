Feature: Loan Approval

  Scenario: Approve loan for eligible applicant
    Given an applicant is 25 years old
    And the applicant has a credit score of 750
    When the loan approval is checked
    Then the loan should be approved

  Scenario: Deny loan for underage applicant
    Given an applicant is 17 years old
    And the applicant has a credit score of 800
    When the loan approval is checked
    Then the loan should be denied

  Scenario: Deny loan for applicant with low credit score
    Given an applicant is 30 years old
    And the applicant has a credit score of 650
    When the loan approval is checked
    Then the loan should be denied

