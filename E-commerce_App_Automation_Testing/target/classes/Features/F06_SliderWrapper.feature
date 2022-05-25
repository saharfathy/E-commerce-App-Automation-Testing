@SmokeTest

Feature: users will be able to open sliders in home page

    #Test Scenario 6 from webinars
    #Test Scenario not exist in classroom
  Background: user open url
    Given user navigate slider to url
    And slider user Click on Login Tab
    And slider Enter valid "ABCD@example.com" and "Pass123456"



    ##this scenario will fail because the link doesn’t open a valid url
  Scenario: first slider is clickable on home page
    Given slider My account tab isDisplayed
    When user click on first slider
    Then verify clicking on home slider1 result

    ##this scenario will fail because the link doesn’t open a valid url
  Scenario: second slider is clickable on home page
    Given slider My account tab isDisplayed
    When user click on second slider
    Then verify clicking on home slider2 result
