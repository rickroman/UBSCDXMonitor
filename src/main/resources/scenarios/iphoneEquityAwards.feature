Feature: Monitor production App
  #Sample Test Scenario Description


  @iPhoneEquity
  Scenario: Login to Equity Awards
    When I switch to native context
    When I launch CDX
    And CDX Equity Awards login
    Then logout of CDX
