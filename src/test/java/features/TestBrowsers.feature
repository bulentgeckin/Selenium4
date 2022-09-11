Feature: Test Browsers


  @browser-test @smoke
  Scenario Outline: Verify all browsers and web drivers are working well
    Given User can start the "<browser>"
    Examples:
      | browser |
      | chrome  |
      | firefox |
      | edge    |
      | safari  |


  @sanity
  Scenario Outline:User can navigate any provided url
    Given User can navigate a web page as "<url>"
    Examples:
      | url                        |
      | www.google.com             |
      | www.microsoft.com          |