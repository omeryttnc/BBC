package mock;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.response.Response;
import org.BBC.constants.ApiEndpoints;
import org.BBC.models.scheduleNotFound.NotFoundSchedule;
import org.BBC.models.schedulePositive.MainSchedule;
import org.BBC.utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.BBC.constants.MockConstants.MYPORT;

/**
 * Provides methods to set up WireMock stubs for schedule-related API responses
 * and retrieve stubbed responses for testing.
 */
public class ScheduleMock {

    /**
     * Enum for defining mock response file names.
     */
    private enum MOCKPATH {
        scheduleResponse,
        scheduleResponseNotFound
    }

    /**
     * Sets up a WireMock stub for a successful schedule response (HTTP 200).
     * <p>
     * The response is loaded from a mock JSON file and includes headers such as
     * "Content-Type" and "Date".
     * </p>
     */
    public void setupScheduleStub() {
        Object mockResponse = JsonUtils.getMockResponse(MainSchedule.class, MOCKPATH.scheduleResponse.toString());

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(ApiEndpoints.BASE_PATH + ApiEndpoints.SCHEDULE))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withHeader("Date", "Tue, 07 Jan 2025 11:59:40 GMT")
                        .withBody((String) mockResponse)));
    }

    /**
     * Sets up a WireMock stub for a "Not Found" schedule response (HTTP 404).
     * <p>
     * The response is loaded from a mock JSON file and includes the "Content-Type"
     * header.
     * </p>
     */
    public void setupScheduleNotFoundStub() {
        Object mockResponse = JsonUtils.getMockResponse(
                NotFoundSchedule.class,
                MOCKPATH.scheduleResponseNotFound.toString());

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo(
                        ApiEndpoints.BASE_PATH + ApiEndpoints.SCHEDULE + ApiEndpoints.DATE)
                )
                .willReturn(WireMock.aResponse()
                        .withStatus(404)
                        .withHeader("Content-Type", "application/json")
                        .withBody((String) mockResponse)));
    }

    /**
     * Retrieves a stubbed response for the schedule API.
     *
     * @param isFound if {@code true}, retrieves a successful schedule response (HTTP 200);
     *                otherwise, retrieves a "Not Found" response (HTTP 404).
     * @return the stubbed API response
     */
    public Response getStubbedResponse(boolean isFound) {
        if (isFound) {
            return given().
                    when().
                    get("http://localhost:" + MYPORT + ApiEndpoints.BASE_PATH + ApiEndpoints.SCHEDULE);
        }
        return given().
                when().
                get("http://localhost:" + MYPORT + ApiEndpoints.BASE_PATH + ApiEndpoints.SCHEDULE + ApiEndpoints.DATE);
    }
}
