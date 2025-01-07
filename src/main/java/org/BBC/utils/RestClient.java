package org.BBC.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.BBC.constants.ApiEndpoints;

/**
 * Utility class for handling REST API requests.
 * <p>
 * This class provides methods to perform common API operations, such as sending GET requests,
 * and includes response validation to ensure the API requests succeed.
 * </p>
 */
public class RestClient {

    /**
     * Initializes the RestClient by setting the base URI and base path for the API.
     * <p>
     * The base URI and base path are sourced from {@link ApiEndpoints}.
     * </p>
     */
    public RestClient() {
        RestAssured.baseURI = ApiEndpoints.BASE_URL;
        RestAssured.basePath = ApiEndpoints.BASE_PATH;
    }

    /**
     * Sends a GET request to the specified API endpoint.
     *
     * @param endpoint the relative path of the API endpoint to which the GET request will be sent
     * @return the response object containing the result of the GET request
     * @throws RuntimeException if the response is null
     */
    public Response getRequest(String endpoint) {
        RequestSpecification request = RestAssured.given();

        Response response = request.get(endpoint);
        validateResponse(response);
        return response;
    }

    /**
     * Validates the API response to ensure it is not null.
     *
     * @param response the response object to validate
     * @throws RuntimeException if the response is null
     */
    private void validateResponse(Response response) {
        if (response == null) {
            throw new RuntimeException("API request failed with null response");
        }
    }
}
