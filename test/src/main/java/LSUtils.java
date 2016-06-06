import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by i81269 on 5/20/2016.
 */
public class LSUtils {


    private static TimeZone tz = TimeZone.getTimeZone("Asia/Katmandu");

    public static String getFormattedTime(String time) {
        int hr = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        String pre=" ";

        if (min == 0) {
            String ampm = "am";
            if (hr > 11 && hr<24) {
                ampm = "pm";
            }
            if (hr > 12) {
                hr = hr - 12;
            }
            pre=" ";
            if(hr>9){
                pre="";
            }
            String sHr=hr+"";
            if(hr==0) sHr="00";
            return pre+sHr + ":00 " + ampm;
        }

        String ampm = "am";
        if( (hr > 11) && hr<24) {
            ampm = "pm";
        }
        if (hr > 12) {
            hr = hr - 12;
        }
        String sHr=hr+"";
        if(hr==0) sHr="00";

        String s_min=""+min;
        if(min<10){
            s_min="0"+min;
        }
        pre=" ";
        if(hr>9){
            pre="";
        }

        return pre+sHr + ":" + s_min + " " + ampm;
    }

    public static int getWeekDay() {
        GregorianCalendar c = new GregorianCalendar(tz);
        // Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_WEEK)-1; // //Sunday = 1

    }

    public static int[] getHourAndMinute() {
        GregorianCalendar cal = new GregorianCalendar(tz);
        return new int[] { cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE) };
    }

    public static int getMinuteFromMidNight(String time) {
        int hr = Integer.parseInt(time.split(":")[0]);
        int min = Integer.parseInt(time.split(":")[1]);
        return hr * 60 + min;
    }

    public static String getWeekDate(int day) {
        GregorianCalendar gc = new GregorianCalendar(tz);
        gc.set(Calendar.DAY_OF_WEEK, day);
        SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy",
                Locale.getDefault());
        df.setTimeZone(tz);
        return df.format(gc.getTime());
    }

    public static String getTodayDate() {
        GregorianCalendar gc = new GregorianCalendar(tz);
        SimpleDateFormat df = new SimpleDateFormat("EEEE - MMM dd, yyyy",
                Locale.getDefault());
        df.setTimeZone(tz);
        return df.format(gc.getTime());
    }


}