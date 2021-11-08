Feature: Monitor production App
  #Sample Test Scenario Description


  @iPhoneEquity
  Scenario: Login to Equity Awards
    When I switch to native context
    When I launch CDX
    And CDX Equity Awards login
    Then validate activity
    And validate holdings
    Then validate awards education
    Then check notifications
    Then logout of CDX
