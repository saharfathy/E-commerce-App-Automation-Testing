@SmokeTest

Feature: user should be able to create account

    #Test Scenario 1 from webinars and classroom

  Scenario: user could register with valid data successfully
    Given user Navigate to url
     And user Click on Register Tab
    When Click on any Gender Option
     And Fill First Name
     And Fill Last Name
     And Select Day
     And Select Month
     And Select Year
     And Enter email address
     And Enter any company name
     And Enter any password
     And Enter same password in Confirm password field
     And Click on REGISTER button
    Then Success message is displayed Your registration completed
     And the color of this message is green
