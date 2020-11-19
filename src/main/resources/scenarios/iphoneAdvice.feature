Feature: Monitor production App
  #Sample Test Scenario Description


  @cdxAdvice
  Scenario: Login to CDX
    When I switch to native context
    When I launch CDX
    And Advice Login to CDX
    Then Check Advice Section
    Then logout of CDX
