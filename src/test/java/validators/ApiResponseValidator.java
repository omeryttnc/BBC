package validators;

import io.restassured.response.Response;
import org.junit.Assert;

import static org.hamcrest.Matchers.lessThan;

/**
 * Utility class for validating API responses.
 * <p>
 * This class provides methods to validate common aspects of API responses,
 * such as status codes, response times, and the existence of headers.
 * </p>
 */
public class ApiResponseValidator {
    /**
     * Validates that the given response has the expected status code.
     *
     * @param response   the response object to validate
     * @param statusCode the expected HTTP status code
     */
    public static void validateStatusCode(Response response, int statusCode) {
        response.then().statusCode(statusCode);
    }

    /**
     * Validates that the response time is less than the specified maximum time.
     *
     * @param response the response object to validate
     * @param maxTime  the maximum allowable response time in milliseconds
     */
    public static void validateResponseTime(Response response, long maxTime) {
        response.then().time(lessThan(maxTime));
    }

    /**
     * Validates that the specified header exists in the response.
     *
     * @param response the response object to validate
     * @param header   the name of the header to check
     * @throws AssertionError if the specified header is not found in the response
     */
    public static void validateHeaderExist(Response response, String header) {

        Assert.assertNotNull(header + " is not found as header", response.getHeaders().get(header));
    }
}
