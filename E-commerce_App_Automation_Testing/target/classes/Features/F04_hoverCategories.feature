@SmokeTest

Feature: user could hover categories and select different category

    #Test Scenario 4 from webinars
    #Test Scenario 6 IN classroom
  Background: user open url
    Given user navigate2 to url
    And user Click on Login Tab hover
    And hover Enter valid "ABCD@example.com" and "Pass123456"



  Scenario: user could hover categories
    Given hover My account tab isDisplayed
    When user hover category and select subcategory
    Then verify hover the result

