@BasicsBDD
  Feature: VersionOne Testing

Scenario Outline: Verify with different login with different types.
  Given I Open the browser and enter the valid url
  When  I enter valid "<UserName>" and "<Password>"
  Then  I Landed on default page.

  Examples:
    | UserName | Password |
    | admin    |@Lt12345  |