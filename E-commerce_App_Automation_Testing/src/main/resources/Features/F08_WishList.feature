@SmokeTest

Feature: users could add items to wish List

    #Test Scenario 8 from webinars
    #Test Scenario 10 in classroom
  Background: user open url
    Given user navigate wishList to url

    #check if the wishlist button is clickable
  Scenario: user add products to wishList
    When user click on product "2" wishList Icon
    Then wishList notification msg of success is visible
    #check if the number of wishlist item is increased
    And the number of wishList items increased



  Scenario: added products are displayed on wishList page
    When user click on product "2" wishList Icon
    Then wishList notification msg of success is visible
    And the number of wishList items increased
    #check if the number of wishlist page label is clickable
    And user go to wishlist page
    #check if the number of wishlist quantities is increased or not
    Then number of quantities are greater than zero in wishlist page
