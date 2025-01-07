package utils;

import io.restassured.response.Response;
import lombok.Data;
import mock.ScheduleMock;

/**
 * Context class for storing scenario-specific data during test execution.
 * <p>
 * This class is primarily used to store and retrieve the API response
 * associated with a specific test scenario.
 * </p>
 */
@Data
public class ScenarioContext {

    /**
     * The API response object associated with the current test scenario.
     */
    private Response response;
    private ScheduleMock scheduleMock;
    private boolean isMocked;
}
