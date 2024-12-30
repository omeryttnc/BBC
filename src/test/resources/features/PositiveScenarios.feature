Feature: API Schedule Validation

  Background: Send Schedule API Request
    Given I make a GET request to the schedule endpoint

  Scenario: Validate Response Status Code and Performance
    Then Verify that the API should return a 200 status code
    Then Verify that the response time should not exceed 1000 milliseconds

  Scenario: Ensure Non-Null 'id' and Correct 'type' in Episode Data
    Then Verify if the id field is never null or empty for all items present in the data array
    Then Verify that the type in episode for every item is always “episode”

  Scenario: Verify Non-Empty 'Title' Field in Episode Schedule
    Then Verify that the title field in episode, is never null or empty for any schedule item

  Scenario: Check Single Live Episode in the Schedule
    Then Verify that only one episode in the list has live field in episode as true

  Scenario: Validate Transmission Start and End Date Consistency
    Then Verify that the transmission_start date value is before the transmission_end date

  Scenario: Verify 'Date' Header in API Response
    Then In the response headers, verify the "Date" value

