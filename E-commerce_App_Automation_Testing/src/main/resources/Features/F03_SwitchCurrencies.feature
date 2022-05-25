@SmokeTest

Feature: guest user could switch between currencies $_€

    #Test Scenario 3 from webinars
    #Test Scenario 5 from classroom

  Scenario: user could switch between currencies $-€
    Given user Navigate to The url
    When user switch currencies to "Euro"
    Then Products display salary with Euro

