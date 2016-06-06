import java.util.ArrayList;
import java.util.List;

/**
 * Created by i81269 on 5/20/2016.
 */
public class GroupSchedule {

    private String groupName = "Group";
    List<DayEvent> dayEvents = new ArrayList<DayEvent>();;

    public String getGroupName() {
        return groupName;
    }

    public List<DayEvent> getDailyEvents() {
        return dayEvents;
    }

    public long duration = 0l;

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean hasEvents(String start, String end) {
        int[] hrmin = LSUtils.getHourAndMinute();
        int now = hrmin[0] * 60 + hrmin[1];
        int start_min = LSUtils.getMinuteFromMidNight(start);

        int end_min = LSUtils.getMinuteFromMidNight(end);

        if (now >= start_min && now < end_min) {
            return true;
        }
        return false;
    }

    public LoadSheddingStatus getStatus(int afterMin) {

        int today = LSUtils.getWeekDay();

        int[] hrmin = LSUtils.getHourAndMinute();
        int now = hrmin[0] * 60 + hrmin[1] + afterMin;

        if(now>24*60){
            //already next day bhayo hai..
            now=now-24*60;
            today=(today+1)%7;
        }

        DayEvent todayEvents = getDailyEvents().get(today);



        boolean hasPowerOut = false;
        int timeTillPowerOn = 0;

        for (int i = 0; i < todayEvents.timeList.size(); i = i + 2) {
            String start = todayEvents.timeList.get(i);
            String end = todayEvents.timeList.get(i + 1);
            int start_min = LSUtils.getMinuteFromMidNight(start);
            int end_min = LSUtils.getMinuteFromMidNight(end);

            if(end_min<start_min){  //add one day here for correction
                end_min+=24*60;
            }
            if (now >= start_min && now < end_min) {
                hasPowerOut = true;
                timeTillPowerOn = end_min - now + afterMin;
                break;
            }
        }
        //check if previous day LS is still active
        if (!hasPowerOut) {
            int yesterday= today-1;
            if(yesterday<0){
                yesterday=6;
            }

            DayEvent yesterdayEvents = getDailyEvents().get(yesterday);

            for (int i = 0; i < yesterdayEvents.timeList.size(); i = i + 2) {
                String start = yesterdayEvents.timeList.get(i);
                String end = yesterdayEvents.timeList.get(i + 1);
                int start_min = LSUtils.getMinuteFromMidNight(start);
                int end_min = LSUtils.getMinuteFromMidNight(end);

                if(end_min<start_min){  //this event pasts
                    //the end minute is for today.
                    if(now<end_min){
                        hasPowerOut = true;
                        timeTillPowerOn = end_min - now + afterMin;
                        break;
                    }

                }
            }
        }
        if (!hasPowerOut) {
            // this is tricky, now need to find out when is the next event
            // need to find out the event that is greater than today's event
            lbl: for (int day = 0; day < 7; day++) {
                DayEvent dayEvent = getDailyEvents().get((today + day) % 7);
                for (int i = 0; i < dayEvent.timeList.size(); i = i + 2) {
                    String start = dayEvent.timeList.get(i);
                    //Log.i("LS", groupName + "  " + "  Start  : " + start
                    //		+ " day =" + day);

                    int start_min = (day * 24 * 60)
                            + LSUtils.getMinuteFromMidNight(start);
                    //Log.i("LS", groupName + "  " + "  Start  : " + start
                    //		+ " day =" + day +" start min = "+start_min +" now ="+ now);
//					Log.i("LS", groupName + "  " + "  Start Min : " + start_min
//							+ " day =" + day);
                    if (now <= start_min) {
                        timeTillPowerOn = start_min - now + afterMin;
                        break lbl;
                    }
                }
            }
        }
        LoadSheddingStatus status = new LoadSheddingStatus();
        status.setLight(!hasPowerOut);
        status.setMinuteUntilNextEvent(timeTillPowerOn);
        return status;

    }

    /**
     * Get Current Status , and time utill next events (which is tricky :-) )
     *
     * @return
     */
    public LoadSheddingStatus getStatus() {
        return getStatus(0);
    }

    public GroupSchedule() {
        // TODO Auto-generated constructor stub
    }
}
