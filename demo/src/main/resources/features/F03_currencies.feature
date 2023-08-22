@smoke
Feature: F03_currencies | user could switch between currencies
  Scenario: Euro currency is selected successfully
    When user select euro currency
    Then euro symbol is shown on the four products displayed in Home page
