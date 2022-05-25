@SmokeTest

Feature: users will be able to search for products with different parameters

    #Test Scenario 5 from webinars
    #Test Scenario 4 IN classroom
  Background: user open url
    Given user navigate to url


  Scenario: user could search using product name
    Given click on search field
    When search for any product name like "Apple"
     And Click on Search Button
    Then verify the result



  Scenario: user could search using serial number of the product
    Given click on search field
    When search for any product SKU like "AS_551_LP"
     And Click on Search Button
    Then verify the result
