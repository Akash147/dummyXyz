/**
 * Created by i81269 on 5/20/2016.
 */
public class LoadSheddingStatus {
    private boolean isLight;
    private int minuteUntilNextEvent;

    public boolean isLight() {
        return isLight;
    }

    public void setLight(boolean isLight) {
        this.isLight = isLight;
    }

    public int getMinuteUntilNextEvent() {
        return minuteUntilNextEvent;
    }

    public void setMinuteUntilNextEvent(int minuteUntilNextEvent) {
        this.minuteUntilNextEvent = minuteUntilNextEvent;
    }

    public String getRemainingTime() {
        String s = "";
        if (minuteUntilNextEvent < 60) {
            s = "" + minuteUntilNextEvent;
            if (minuteUntilNextEvent < 10) {
                s = "0" + minuteUntilNextEvent;
            }
            return s + " m";
        } else {
            int hr = minuteUntilNextEvent / 60;
            int min = minuteUntilNextEvent - hr * 60;
            s = hr + " hr";
            if (min > 0) {
                if (min < 10) {
                    s += " 0" + min;
                } else {
                    s += " " + min;
                }
                s += " m";

            }
            s += "";
        }
        return s;
    }
/*
    public String getRemainingTimeLocaleAware(Context context) {
        String locale = LanguageUtility.getCurrentLanguage(context);
        String s = "";
        if (minuteUntilNextEvent < 60) {
            s = "" + minuteUntilNextEvent;
            if (minuteUntilNextEvent < 10) {
                s = "0" + minuteUntilNextEvent;
            }
            if(locale.equals("ne"))
                return "??:" + LanguageUtility.toDevnagariLipi(Integer.parseInt(s));
            else
                return "00:" + s;
        } else {
            int hr = minuteUntilNextEvent / 60;
            int min = minuteUntilNextEvent - hr * 60;
            s = (locale.equals("ne") ? LanguageUtility.toDevnagariLipi(hr):hr) + ":";
            if (min > 0) {
                String m = locale.equals("ne") ? LanguageUtility.toDevnagariLipi(min) : min+"";
                if (m.length()<2) {
                    s += (locale.equals("ne") ? "?":"0") + m;
                } else {
                    s += m;
                }
            }
        }
        return s;
    }
*/
}