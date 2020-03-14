package frameworks.joda;

import java.time.ZoneId;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.junit.Test;

public class JodaTimeTestCase {

    @Test
    public void getCurrentTimezoneAndTime_1() {

        ZoneId zoneId = ZoneId.of("America/Chicago");
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        DateTimeZone dateTimezone = DateTimeZone.forTimeZone(timeZone);

        LocalDateTime now = LocalDateTime.now(dateTimezone);
        System.out.println(now);
    }

    @Test
    public void getCurrentTime() {

        ZoneId zoneId = ZoneId.of("America/Chicago");
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        DateTimeZone dateTimezone = DateTimeZone.forTimeZone(timeZone);
        org.joda.time.DateTime dtx = new org.joda.time.DateTime(dateTimezone);
        System.out.println(dtx.toLocalDateTime());
    }

    @Test
    public void getSpecificDateTime() {
        LocalDateTime dt1 = new LocalDateTime(2016, 1, 1, 0, 0, 0, 0);
        LocalDateTime dt2 = new LocalDateTime(2016, 12, 31, 23, 59, 59, 999);
        System.out.println(dt1.toDate());
        System.out.println(dt2.toDate());
    }


}
