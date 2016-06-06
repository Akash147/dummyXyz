import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.rmi.runtime.Log;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by i81269 on 5/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        String response = getJSONFile("nls.json");
        String effectiveDate = "";
//        Log.d("LS", response);
        System.out.println("LS " + response);
        // initializing 2D list
        List<GroupSchedule> listSection = new ArrayList<GroupSchedule>();

        // // Firstly populating group 1 from json

        try {
            JSONObject jObj = new JSONObject(response);
            effectiveDate = (String) jObj.get("effective_date");
            JSONArray jArr = jObj.getJSONArray("data");
            System.out.println("LS "+ jArr.toString());
            GroupSchedule group = new GroupSchedule();
            group.setGroupName("Group 1");

            for (int j = 0; j < jArr.length(); j++) {
                JSONArray day_arr = jArr.getJSONArray(j);

                DayEvent devent = new DayEvent();
                group.getDailyEvents().add(devent);

                for (int k = 0; k < day_arr.length(); k++) {
                    String timeS = day_arr.getString(k);
                    devent.timeList.add(timeS);
                }
            }

            listSection.add(group);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int group = 1; group < 7; group++) { // populating for other groups

            GroupSchedule group_schedule = new GroupSchedule();
            group_schedule.setGroupName("Group " + (group + 1));

            // // populate lSec
            for (int day = 0; day < 7; day++) { // exchanging days

                GroupSchedule firstGroup = listSection.get(0);

                DayEvent devent = firstGroup.getDailyEvents().get(
                        (day - group + 7) % 7);
                group_schedule.getDailyEvents().add(devent);
                System.out.println("TAG "+ "group =" + firstGroup.getDailyEvents());
            }
            listSection.add(group_schedule);
        }
        List<GroupSchedule> schedules = new ArrayList<GroupSchedule>(listSection);

        ScheduleResponse sr = new ScheduleResponse();
        sr.setEffectiveDate(effectiveDate);
        sr.setSchedules(schedules);

        Gson gson = new Gson();
        String s = gson.toJson(sr);
        System.out.println("LS "+ s);
    }

    public static String getJSONFile(String filename) {
        try {
            InputStream is = new BufferedInputStream(new FileInputStream("C:\\Users\\i81269\\Downloads\\test\\src\\main\\resources\\nls.json"));
            int size = is.available();
            byte buffer[] = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
