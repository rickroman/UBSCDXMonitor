Feature: Monitor production App
  #Sample Test Scenario Description


  @cdxiPhone
  Scenario: Login to CDX
    When I switch to native context
    When I launch CDX
    And Login to CDX
    Then validate accounts
    And validate profile
    And validate menu
    Then logout of CDX
