@version:Release-1 @version:Sprint-1.1
Feature: EDA Login

  @UniqueBrowser
  Scenario: Login
    Given I navigate to EDA Login Page
    When I provide Username and Password
    And I Click on Login button
    Then Home Page should be Displayed

  Scenario Outline: Administrator Creation
    Given Manage Administrator Page is displayed
    And I navigate to Create Administrator Page
    When I provide valid Administrator "<Username>", "<FirstName>", "<LastName>", "<EmailAddress>" and "<Password>"
    And clicking on Create Administrator button
    Then User Successfully created message should be displayed

    Examples: 
      | Username     | FirstName | LastName | EmailAddress           | Password      |
      | Gurunathan41 | Admin     | User     | charles@lexisnexis.com | Gpassword123! |
