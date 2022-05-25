@SmokeTest

Feature: user should be able to log in to their account

    #Test Scenario 2 from webinars and classroom

  Scenario: User could log in with valid email and password successfully
    Given user Navigate to website url
    And user Click on Login Tab
    When Enter valid "ABCD@example.com" and "Pass123456"
    And Click on LOG IN button
    Then website opens
    And My account tab isDisplayed