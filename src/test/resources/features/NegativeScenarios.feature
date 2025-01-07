Feature: Error Handling in Schedule API

  Scenario: Validate 404 Error and Error Object Properties with live data
    Given I send a GET request to the schedule endpoint with date
    Then Verify that the API should return a 404 status code
    And Verify the error object should contain the property
      | details            |
      | http_response_code |

  @scheduleNotFound
  Scenario: Validate 404 Error and Error Object Properties with mock data
    Given I send a GET request to the schedule endpoint with date
    Then Verify that the API should return a 404 status code
    And Verify the error object should contain the property
      | details            |
      | http_response_code |