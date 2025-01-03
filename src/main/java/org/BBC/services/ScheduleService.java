package org.BBC.services;


import io.restassured.response.Response;
import org.BBC.constants.ApiEndpoints;
import org.BBC.models.MainSchedule;
import org.BBC.models.Schedule;
import org.BBC.utils.JsonUtils;
import org.BBC.utils.RestClient;

public class ScheduleService {
private final RestClient restClient;

    public ScheduleService() {
        this.restClient = new RestClient();
    }

    //Fetch schedule from the API
    public Schedule getSchedule() {
        Response response = restClient.getRequest(ApiEndpoints.SCHEDULE);
        return JsonUtils.fromJson(response.asString(), MainSchedule.class).getSchedule();
    }
}
