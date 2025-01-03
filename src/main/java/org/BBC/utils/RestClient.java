package org.BBC.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.BBC.constants.ApiEndpoints;

public class RestClient {
    public RestClient() {
        RestAssured.baseURI = ApiEndpoints.BASE_URL;
        RestAssured.basePath = ApiEndpoints.BASE_PATH;
    }

    // Helper method for GET request
    public Response getRequest(String endpoint) {
        RequestSpecification request = RestAssured.given();

        Response response = request.get(endpoint);
        validateResponse(response);
        return response;
    }

    // Validate the response
    private void validateResponse(Response response) {
        if (response == null) {
            throw new RuntimeException("API request failed with null response");
        }
    }
}
