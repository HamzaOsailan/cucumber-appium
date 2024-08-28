@setup
Feature: Simple Login

  Scenario: Open app and click login button
    Given the app is open
    When I click the login button
    Then I should see the login screen
    Then tearDown
