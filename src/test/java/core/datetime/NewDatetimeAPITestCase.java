package core.datetime;

import java.time.Clock;
import java.time.ZoneId;
import java.util.TimeZone;
import org.junit.Test;

public class NewDatetimeAPITestCase {

    @Test
    public void getCurrentTimezoneAndTime() {
        ZoneId zoneId = ZoneId.of("America/Chicago");
//        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
        System.out.println(java.time.LocalDateTime.now(Clock.system(zoneId)));
    }
}
