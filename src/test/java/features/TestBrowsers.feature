Feature: Test Browsers


  @browser
  Scenario Outline: Verify all browsers and web drivers are working well
    Given User can start the "<browser>"
    Examples:
      | browser |
      | chrome  |
      | firefox |
      | edge    |