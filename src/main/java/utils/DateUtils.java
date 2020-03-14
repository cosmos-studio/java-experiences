package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class DateUtils {

    public static int calculateAge(LocalDate birthday, LocalDate baseDay) {
        Period period = birthday.until(baseDay);
        int year = period.getYears();
        if (period.getMonths() < 0 || period.getDays() < 0) {
            year = period.getYears() - 1;
        }
        return year;
    }


    public static boolean isDateValid(String dateToValidate, String dateFromat) {
        if (dateToValidate == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


}
