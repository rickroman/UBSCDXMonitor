@monitoring
Feature: Monitor production App
  #Sample Test Scenario Description


  @cdx
  Scenario: Login to CDX
    When I switch to native context
    When I launch CDX
    And Login to CDX
    Then validate accounts
  #  And create milestone
  #  Then delete milestone
  #  And validate profile
    Then logout of CDX
