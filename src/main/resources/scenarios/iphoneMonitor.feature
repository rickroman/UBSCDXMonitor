Feature: Monitor production App
  #Sample Test Scenario Description


  @cdxiPhone
  Scenario: Login to CDX
    When I switch to native context
    When I launch CDX
    And Login to CDX
    Then check account activity
   Then validate cash at a glance
    And view insights
    Then view market insights
    Then validate accounts
    Then check milestone
    And validate profile
   Then validate banking services
    And validate relationship
    Then validate mindset
    #And check settings
    Then get support
    And check feedback
    And check Legal services
    Then contact financial advisor
    Then logout of CDX
