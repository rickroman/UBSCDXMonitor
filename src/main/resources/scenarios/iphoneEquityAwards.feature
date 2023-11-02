 Feature: Monitor production App
  #Sample Test Scenario 


  @iPhoneEquity
  Scenario: Equity Awards
    When I switch to native context
    When I launch CDX
    And CDX Equity Awards login
    #Then validate activity
    #And validate holdings
    Then check transactions
    Then validate awards education
    Then check notifications
    #And check MW balances
    #Then check MW Holdings
    #And check MW Activity
    Then check MW Financial Tools
    #And check my information
    Then EW check settings
    And EW check support
    Then EW check legal
    And EW get in touch
    Then logout of CDX
