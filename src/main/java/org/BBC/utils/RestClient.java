package org.BBC.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.BBC.constants.ApiEndpoints;

import static io.restassured.RestAssured.given;

public class RestClient {
    public static Response get(String endpoint) {
        RestAssured.baseURI = ApiEndpoints.BASE_URL;
        RestAssured.basePath = ApiEndpoints.BASE_PATH;

        return given()
                .when()
                .get(endpoint);
    }
}
