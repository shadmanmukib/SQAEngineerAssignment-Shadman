Project Overview: AcmeAI QA Automation for validating the Legal Assistance Platform
This repository contains the automated test suite and quality assurance documentation for the AcmeAI Legal Assistance Platform. The suite validates a Next.js/React frontend and a FastAPI backend, focusing on legal document processing and AI-driven query responses.
+3

## 🛠️ Setup and Installation
1. Prerequisites
Java JDK 8+: Required for running the TestNG suite.


Maven: Used for dependency management and test execution.


ChromeDriver: Ensure the version matches your local Google Chrome browser.


Environment: The Backend should be running on http://localhost:8000 and the Frontend on http://localhost:3001.
+1

2. Execution
To run the entire test suite via the command line, use:

Bash
mvn clean test
## 📊 Test Coverage Summary
The automation suite is designed to cover the full lifecycle of a user interaction while auditing backend security.

API Coverage (RestAssured)

Functional Integration: Validates the /generate endpoint for successful 200 OK responses and result presence.
+1


Performance: Ensures AI response latency is below the 1.5s threshold.
+2

Security Auditing:

Checks for SQL Injection resilience.
+1

Verifies XSS payload rejection/sanitization.
+1

Validates critical Security Headers (X-Frame-Options, X-Content-Type-Options).
+1

UI Coverage (Selenium + TestNG)

End-to-End Workflow: Automates document (PDF) upload, query submission, and response rendering.
+1


Form Validation: Confirms that empty inputs trigger appropriate error messages.


Input Integrity: Verifies that the frontend correctly handles and sanitizes potentially malicious scripts in the query box.

## 📝 Code Quality & Architecture Observations
A comprehensive code review identified several critical areas for improvement to meet production standards:


Security Vulnerability: User passwords are currently stored in plaintext, posing a critical risk.
+1


Recommendation: Implement bcryptjs for hashing.


Architecture: The backend violates "Separation of Concerns" by combining route handling and DB queries in the controller.


Recommendation: Transition to a Service Layer pattern.


Reliability: The frontend lacks user-facing error feedback for failed API calls, leading to a poor user experience.
+1

## 🔗 Important Resources

Test Plan & Strategy: Full Test Strategy Document 


Automation Repository: GitHub - SQAEngineerAssignment-Shadman 


Full Code Review Notes: Detailed Observations
