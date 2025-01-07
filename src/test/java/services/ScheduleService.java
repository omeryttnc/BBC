package services;

import io.restassured.response.Response;
import org.BBC.constants.ApiEndpoints;
import org.BBC.models.scheduleNotFound.NotFoundSchedule;
import org.BBC.models.schedulePositive.MainSchedule;
import org.BBC.models.schedulePositive.Schedule;
import org.BBC.utils.JsonUtils;
import org.BBC.utils.RestClient;
import utils.ScenarioContext;

/**
 * Provides methods to interact with the Schedule API and retrieve schedule data.
 * <p>
 * This service handles both mocked and real API requests based on the context.
 * </p>
 */
public class ScheduleService {

    private final RestClient restClient;
    private final ScenarioContext scenarioContext;

    /**
     * Constructs a new ScheduleService with the provided scenario context.
     *
     * @param scenarioContext the context to manage API mocking and request responses
     */
    public ScheduleService(ScenarioContext scenarioContext) {
        this.restClient = new RestClient();
        this.scenarioContext = scenarioContext;
    }

    /**
     * Retrieves the schedule data from the API or mock server.
     * <p>
     * If mocking is enabled, the response is retrieved from the mock server;
     * otherwise, it is fetched from the real API endpoint.
     * </p>
     *
     * @return the {@link Schedule} object containing the schedule details
     */
    public Schedule getSchedule() {
        Response response = scenarioContext.isMocked()
                ? scenarioContext.getScheduleMock().getStubbedResponse(true)
                : restClient.getRequest(ApiEndpoints.SCHEDULE);
        scenarioContext.setResponse(response);
        return JsonUtils.fromJson(response.asString(), MainSchedule.class).getSchedule();
    }

    /**
     * Retrieves a "Not Found" schedule response from the API or mock server.
     * <p>
     * If mocking is enabled, the response is retrieved from the mock server;
     * otherwise, it is fetched from the real API endpoint.
     * </p>
     *
     * @return the {@link NotFoundSchedule} object containing error details
     */
    public NotFoundSchedule getNotFoundSchedule() {
        Response response = scenarioContext.isMocked()
                ? scenarioContext.getScheduleMock().getStubbedResponse(false)
                : restClient.getRequest(ApiEndpoints.SCHEDULE + ApiEndpoints.DATE);
        scenarioContext.setResponse(response);
        return JsonUtils.fromJson(response.asString(), NotFoundSchedule.class);
    }
}
