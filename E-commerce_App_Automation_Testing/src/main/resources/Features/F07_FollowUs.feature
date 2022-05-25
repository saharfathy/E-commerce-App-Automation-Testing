@SmokeTest

Feature: users could open followUs links

    #Test Scenario 7 from webinars
    #Test Scenario not exist in classroom
  Background: user open url
    Given user navigate followUs to url

  Scenario: user opens facebook link
    When user click on facebook Icon
    Then verify that facebook url opened


  Scenario: user opens twitter link
    When user click on twitter Icon
    Then verify that twitter url opened


    ##this scenario will fail because the link doesn’t open a valid url
  Scenario: user opens rss link
    When user click on rss Icon
    Then verify that rss url opened


  Scenario: user opens youtube link
    When user click on youtube Icon
    Then verify that youtube url opened