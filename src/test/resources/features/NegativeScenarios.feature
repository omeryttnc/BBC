Feature: Error Handling in Schedule API

  Scenario Outline: Validate 404 Error and Error Object Properties
    Given I send a GET request to the schedule endpoint "/2023-09-11"
    Then Verify that the API should return a 404 status code
    And Verify the error object should contain the property "<property>"
    Examples: properties
      | property           |
      | details            |
      | http_response_code |