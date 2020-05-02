@monitoring
Feature: Monitor production App
  #Sample Test Scenario Description


  @ipad
  Scenario: Login to CDX
    When I switch to native context
    When I launch CDX
    And Login to CDX
    And view insights
    Then validate accounts
   # Then check milestone
    And validate profile
    Then validate banking services
    And validate relationship
    Then validate mindset
    And check settings
    Then get support
    And check feedback
    And check legal
    Then contact financial advisor
    Then logout of CDX
