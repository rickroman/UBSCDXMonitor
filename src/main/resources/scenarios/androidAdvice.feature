Feature: Monitor production App
  #Sample Test Scenario Description


  @cdxAdviceAndroid
  Scenario: Advice Advantage
    #When I switch to native context
    #Then I Clear UBS Cache
    Then I launch CDX
    And Advice Login to CDX
    Then Check Advice Section
    And Navigate advice advantage
    Then logout of CDX