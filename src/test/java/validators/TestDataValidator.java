package validators;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;

import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.assertTrue;

/**
 * Utility class for validating test data.
 * <p>
 * This class provides generic and date-specific validation methods
 * to ensure test data meets certain conditions.
 * </p>
 */
public class TestDataValidator {

    /**
     * Asserts that the given object is not null or empty.
     *
     * @param t   the object to validate
     * @param <T> the type of the object
     * @throws AssertionError if the object is null or empty
     */
    public static <T> void assertIfIsNotNullOrEmpty(T t) {
        Assert.assertTrue(t + " is either null or empty", t != null && !ObjectUtils.isEmpty(t));
    }

    /**
     * Asserts that the start date is before the end date.
     *
     * @param startDate the start date in ISO-8601 format (e.g., "2025-01-07T10:15:30+01:00[Europe/Paris]")
     * @param endDate   the end date in ISO-8601 format (e.g., "2025-01-08T10:15:30+01:00[Europe/Paris]")
     * @throws AssertionError         if the start date is not before the end date
     * @throws DateTimeParseException if the provided dates are not in valid ISO-8601 format
     */
    public static void assertIfStartDateBeforeEndDate(String startDate, String endDate) {
        ZonedDateTime zoneStartDate = ZonedDateTime.parse(startDate);
        ZonedDateTime zoneEndDate = ZonedDateTime.parse(endDate);
        assertTrue("end date is before start date", zoneStartDate.isBefore(zoneEndDate));
    }
}
