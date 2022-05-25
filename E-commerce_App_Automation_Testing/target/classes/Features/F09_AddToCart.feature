@SmokeTest

Feature: users could add items to Shopping Cart

    #Test Scenario 9 from webinars
    #Test Scenario 9 in classroom
  Background: user open url
    Given user navigate Cart to url
    And Cart user Click on Login Tab
    And Cart Enter valid "ABCD@example.com" and "Pass123456"

    #check if the Add to Shopping Cart button is clickable
  Scenario: user add products to Shopping Cart by button
    Given Cart My account tab isDisplayed
    When user click on product "2" Add to Cart Button
    Then Shopping Cart notification msg of success is visible
    #check if the number of Shopping Cart item is increased
    And the number of Shopping Cart items increased


  Scenario: added products are displayed on Shopping Cart page
    Given Cart My account tab isDisplayed
    When user click on product "2" Add to Cart Button
    Then Shopping Cart notification msg of success is visible
    And the number of Shopping Cart items increased
    #check if the Shopping Cart page label is clickable
    And user go to Shopping Cart page
     #check if the item exist in the shopping cart and quantity greater than 0
    Then  quantity greater than 0
    And item exist in the shopping cart