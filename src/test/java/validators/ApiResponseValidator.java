package validators;

import io.restassured.response.Response;
import org.junit.Assert;

import static org.hamcrest.Matchers.lessThan;

public class ApiResponseValidator {
    public static void validateStatusCode(Response response, int statusCode) {
        response.then().statusCode(statusCode);
    }

    public static void validateResponseTime(Response response, long maxTime) {
        response.then().time(lessThan(maxTime));
    }

    public static void checkHeaderExist(Response response, String header) {
        Assert.assertNotNull(header + " is not found as header", response.getHeaders().get(header));
    }
}
