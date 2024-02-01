Feature: Testing different request on the virgin application

  Scenario: Check if the virgin application can be accessed by users
    When User sends a GET request to list endpoint with currency as a GBP
    Then I verify currency is in GBP

    Scenario: Verify EUR currency
      When User sends a GET request to list endpoint with currency as a EUR
      Then I verify currency is in EUR

  Scenario: Verify SEK currency
    When User sends a GET request to list endpoint with currency as a SEK
    Then I verify currency is in SEK


    Scenario Outline: Verify Different Currency
      When User send Get request to list endpoint with currency as "<currency>"
      Then Verify currency "<currency>"
      Examples:
        | currency |
        | GBP      |
        | EUR      |
        | SEK      |
