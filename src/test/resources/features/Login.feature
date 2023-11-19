Feature: Login verification
  Features include all the scenarios for login

  Scenario: Login
    Given current url is "https://someaddress.com"
    When user enters valid username and password
    And user clicks login button
    Then login successful