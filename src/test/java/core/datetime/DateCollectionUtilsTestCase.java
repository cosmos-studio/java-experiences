package core.datetime;

import java.time.LocalDate;
import org.junit.Test;
import utils.DateUtils;
import static org.junit.Assert.assertEquals;

public class DateCollectionUtilsTestCase {

    @Test
    public void calculateAge() {
        LocalDate baseDay = LocalDate.of(2013, 6, 9);
        System.out.printf("[%s] <- baseDay %n", baseDay);
        assertEquals(2, DateUtils.calculateAge(LocalDate.of(2011, 6, 9), baseDay));//2
        assertEquals(1, DateUtils.calculateAge(LocalDate.of(2011, 6, 10), baseDay));//1
        assertEquals(1, DateUtils.calculateAge(LocalDate.of(2012, 6, 9), baseDay));//1
        assertEquals(0, DateUtils.calculateAge(LocalDate.of(2012, 6, 10), baseDay));//0
        assertEquals(0, DateUtils.calculateAge(LocalDate.of(2013, 6, 9), baseDay));//0
        assertEquals(-1, DateUtils.calculateAge(LocalDate.of(2013, 6, 10), baseDay));//-1
        assertEquals(-1, DateUtils.calculateAge(LocalDate.of(2014, 6, 9), baseDay));//-1
        assertEquals(-2, DateUtils.calculateAge(LocalDate.of(2014, 6, 10), baseDay));//-2

        baseDay = LocalDate.of(2013, 1, 1);
        System.out.printf("[%s] <- baseDay %n", baseDay);
        assertEquals(2, DateUtils.calculateAge(LocalDate.of(2011, 1, 1), baseDay));//2
        assertEquals(1, DateUtils.calculateAge(LocalDate.of(2011, 1, 2), baseDay));//1
        assertEquals(1, DateUtils.calculateAge(LocalDate.of(2012, 1, 1), baseDay));//1
        assertEquals(0, DateUtils.calculateAge(LocalDate.of(2012, 1, 2), baseDay));//0
        assertEquals(0, DateUtils.calculateAge(LocalDate.of(2013, 1, 1), baseDay));//0
        assertEquals(-1, DateUtils.calculateAge(LocalDate.of(2013, 1, 2), baseDay));//-1
        assertEquals(-1, DateUtils.calculateAge(LocalDate.of(2014, 1, 1), baseDay));//-1
        assertEquals(-2, DateUtils.calculateAge(LocalDate.of(2014, 1, 2), baseDay));//-2
    }
}