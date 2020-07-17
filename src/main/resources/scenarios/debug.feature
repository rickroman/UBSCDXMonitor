Feature: Monitor production App
  #Sample Test Scenario Description


  @debug
  Scenario: Debug test
    When I switch to native context
    When I debug launch CDX
    And debug_Login to CDX

    Then logout of CDX
