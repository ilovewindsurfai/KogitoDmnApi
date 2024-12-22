# Loan Approval Decision Model

## Overview

This document describes the Decision Model and Notation (DMN) for the Loan Approval process. The model is designed to determine whether a loan application should be approved based on the applicant's age and credit score.

## Model Details

### Inputs

The model takes two inputs:

1. **Age** (number): The age of the loan applicant.
2. **CreditScore** (number): The credit score of the loan applicant.

### Decision

The model makes one decision:

- **LoanApproval** (boolean): Whether the loan is approved (true) or denied (false).

### Decision Logic

The loan approval decision is based on the following rules:

1. If the applicant is 18 years or older AND has a credit score of 700 or higher, the loan is approved.
2. If the applicant is under 18 years old, the loan is automatically denied, regardless of credit score.
3. If the applicant is 18 years or older but has a credit score below 700, the loan is denied.

## Decision Table

The decision logic is implemented using a decision table with the following structure:

| Age     | Credit Score | Loan Approval |
|---------|--------------|---------------|
| >= 18   | >= 700       | true          |
| < 18    | -            | false         |
| >= 18   | < 700        | false         |

## Using the DMN with the API

The Loan Approval DMN is integrated into a Spring Boot API. To use this decision model:

1. Send a POST request to the `/loan-approval` endpoint.
2. Include a JSON body with the following structure:

   \`\`\`json
   {
     "Age": 25,
     "CreditScore": 750
   }
   \`\`\`

3. The API will return a JSON response with the decision:

   \`\`\`json
   {
     "LoanApproval": true
   }
   \`\`\`

## Example Scenarios

1. Approved Loan:
   - Input: Age = 25, CreditScore = 750
   - Output: LoanApproval = true

2. Denied Loan (Age):
   - Input: Age = 17, CreditScore = 800
   - Output: LoanApproval = false

3. Denied Loan (Credit Score):
   - Input: Age = 30, CreditScore = 650
   - Output: LoanApproval = false

## Modifying the DMN

If you need to modify the decision logic:

1. Open the \`LoanApproval.dmn\` file in a DMN-compatible editor.
2. Adjust the decision table or add new rules as needed.
3. Ensure that any changes are reflected in the API implementation and unit tests.

## Best Practices

- Regularly review and update the decision model to align with current business rules and regulations.
- Ensure that all possible input combinations are accounted for in the decision table.
- Keep this documentation up-to-date with any changes made to the DMN model.

