package org.BBC.services;


import io.restassured.response.Response;
import org.BBC.constants.ApiEndpoints;
import org.BBC.models.MainSchedule;
import org.BBC.models.Schedule;
import org.BBC.utils.JsonUtils;
import org.BBC.utils.RestClient;

import java.util.List;

public class ScheduleService {

    //Fetch schedule from the API
    public Schedule getSchedule() {
        Response response = RestClient.get(ApiEndpoints.SCHEDULE);
        return JsonUtils.fromJson(response.asString(), MainSchedule.class).getSchedule();
    }
}
