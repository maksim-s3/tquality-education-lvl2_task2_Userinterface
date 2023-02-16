package aquality.selenium.template.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static SimpleDateFormat formatter = null;

    public static Date getDate(String template) {
        formatter = new SimpleDateFormat(template, Locale.ENGLISH);
        try {
            return formatter.parse(formatter.format(new Date()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date getDate(String template, Date date) {
        formatter = new SimpleDateFormat(template, Locale.ENGLISH);
        try {
            return formatter.parse(formatter.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date getDateFromString(String template, String string) {
        formatter = new SimpleDateFormat(template, Locale.ENGLISH);
        try {
            return formatter.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStringFromDate(String template, Date date) {
        formatter = new SimpleDateFormat(template, Locale.ENGLISH);
        return formatter.format(date);
    }
}
