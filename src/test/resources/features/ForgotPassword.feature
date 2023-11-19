Feature: Forgot password verification
  Features include all the scenarios for Forgot Password

  Scenario: Forgot Password
    Given current url is "https://someaddress.com"
    When user clicks Forgot Password link
    And user enters valid username and email
    And user clicks Submit button
    Then link reset email has been sent