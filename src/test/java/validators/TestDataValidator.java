package validators;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;

import java.time.ZonedDateTime;

public class TestDataValidator {
    public static <T> void assertIfIsNotNullOrEmpty(T t) {
        Assert.assertTrue(t + " is either null or empty", t != null && !ObjectUtils.isEmpty(t));
    }

    public static void isStartDateBeforeEndDate(String startDate, String endDate) {
        ZonedDateTime zoneStartDate = ZonedDateTime.parse(startDate);
        ZonedDateTime zoneEndDate = ZonedDateTime.parse(endDate);
        Assert.assertTrue("end date is before start date", zoneStartDate.isBefore(zoneEndDate));
    }
}
