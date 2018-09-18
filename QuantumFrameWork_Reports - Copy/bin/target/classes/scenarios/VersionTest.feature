@Version
Feature: Working with Versionone

  
  Scenario: Login and logout in Version
    Given Login Version application with valid username and password
    When Verify landing page
    Then Logout from Application
