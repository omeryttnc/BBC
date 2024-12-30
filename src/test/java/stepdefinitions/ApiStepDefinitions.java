package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.BBC.constants.ApiEndpoints;
import org.BBC.models.Schedule;
import org.BBC.services.ScheduleService;
import org.BBC.utils.RestClient;
import org.junit.Assert;
import validators.TestDataValidator;
import validators.ApiResponseValidator;

public class ApiStepDefinitions {
    private Response response;
    Schedule scheduleService;
    private final String EPISODE = "episode";

    @Given("I make a GET request to the schedule endpoint")
    @Step("Making a GET request to the schedule endpoint")
    @Description("This step makes a GET request to fetch the schedule from the API endpoint.")
    public void i_make_a_get_request_to_the_schedule_endpoint() {
        response = RestClient.get(ApiEndpoints.SCHEDULE);
        scheduleService = new ScheduleService().getSchedule();
    }

    @Then("Verify that the API should return a {int} status code")
    @Step("Verifying the status code of the response")
    @Description("Verify that the status code of the API response is as expected.")
    public void the_response_status_code_should_be(int statusCode) {
        ApiResponseValidator.validateStatusCode(response, statusCode);
    }

    @Then("Verify that the response time should not exceed {int} milliseconds")
    @Step("Verifying the response time")
    @Description("Verifying that the response time of the API is within the expected limit.")
    public void the_response_time_should_be_less_than(int maxTime) {
        ApiResponseValidator.validateResponseTime(response, maxTime);
    }

    @Then("Verify if the id field is never null or empty for all items present in the data array")
    @Step("Verifying if the 'id' field is never null or empty for all items")
    @Description("Verify that the 'id' field is never null or empty for all items in the response data.")
    public void the_id_field_is_never_null_or_empty_for_all_items_present_in_the_data_array() {
        // channel Id checked
        String channelId = scheduleService.getChannel().getId();
        TestDataValidator.assertIfIsNotNullOrEmpty(channelId);

        // elements ids checked
        scheduleService.getElements()
                .forEach(t -> TestDataValidator.assertIfIsNotNullOrEmpty(t.getId()));

        // episode ids checked
        scheduleService.getElements()
                .forEach(
                        t -> TestDataValidator.assertIfIsNotNullOrEmpty(t.getEpisode().getId())
                );

        // episode version ids checked
        scheduleService.getElements()
                .forEach(
                        t -> t.getEpisode().getVersions().forEach(
                                x -> TestDataValidator.assertIfIsNotNullOrEmpty(x.getId())
                        )
                );

        // episode master brand ids checked
        scheduleService.getElements()
                .forEach(
                        t -> TestDataValidator.assertIfIsNotNullOrEmpty(t.getEpisode().getMaster_brand().getId())
                );
    }

    @Then("Verify that the type in episode for every item is always “episode”")
    @Step("Verifying the type in episode for every item")
    @Description("Verifying that the type field in the episode for every item is always 'episode'.")
    public void the_type_in_episode_for_every_item_is_always_episode() {
        boolean isAllTypeEqualEpisode = scheduleService.getElements()
                .stream()
                .allMatch(t -> t.getEpisode().getType().equals(EPISODE));
        Assert.assertTrue("The type in episode is not always 'episode'", isAllTypeEqualEpisode);
    }

    @Then("Verify that the title field in episode, is never null or empty for any schedule item")
    @Step("Verifying the title field in episode for every schedule item")
    @Description("Verify that the title field in episode is never null or empty for any schedule item.")
    public void the_title_field_in_episode_is_never_null_or_empty_for_any_schedule_item() {
        scheduleService.getElements()
                .forEach(
                        t -> TestDataValidator.assertIfIsNotNullOrEmpty(t.getEpisode().getTitle())
                );
    }

    @Then("Verify that only one episode in the list has live field in episode as true")
    @Step("Verifying that only one episode has live field as true")
    @Description("Verify that only one episode in the list has the 'live' field in 'episode' as true.")
    public void only_one_episode_in_the_list_has_live_field_in_episode_as_true() {
        long howManyScheduleIsLive = scheduleService.getElements()
                .stream()
                .filter(t -> t.getEpisode().isLive())
                .count();
        Assert.assertEquals("The number of live episodes is not correct", 1, howManyScheduleIsLive);
    }

    @Then("Verify that the transmission_start date value is before the transmission_end date")
    @Step("Verifying that the transmission start date is before the transmission end date")
    @Description("Verify that the transmission start date is before the transmission end date for all episodes.")
    public void the_transmission_start_date_value_is_before_the_transmission_end_date() {
        scheduleService.getElements()
                .forEach(
                        t -> TestDataValidator.isStartDateBeforeEndDate(t.getTransmission_start(), t.getTransmission_end())
                );
    }

    @Then("In the response headers, verify the {string} value")
    @Step("Verifying the response header value")
    @Description("Verify the existence of the specified header value in the response headers.")
    public void response_headers_verify_the_value(String header) {
        ApiResponseValidator.checkHeaderExist(response, header);
    }

    @Given("I send a GET request to the schedule endpoint {string}")
    @Step("Sending a GET request to the schedule endpoint with the specified string")
    @Description("Sending a GET request to the schedule endpoint with a dynamic string appended.")
    public void GET_request_to_the_schedule_endpoint(String endpoint) {
        response = RestClient.get(ApiEndpoints.SCHEDULE + endpoint);
    }

    @And("Verify the error object should contain the property {string}")
    @Step("Verifying that the error object contains the specified property")
    @Description("Verify that the error object in the response contains the specified property.")
    public void the_error_object_had_the_properties(String property) {
        TestDataValidator.assertIfIsNotNullOrEmpty(response.jsonPath().getString("error." + property));
    }
}
