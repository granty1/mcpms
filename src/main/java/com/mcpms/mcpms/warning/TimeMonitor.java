package com.mcpms.mcpms.warning;

/**
 * @author guolin
 */
public class TimeMonitor {

    public static boolean isSatisfied(String time) {

        String[] split = time.split(" ");
        String[] strings = split[1].split(":");
        int hour = Integer.parseInt(strings[0]);
        int minute = Integer.parseInt(strings[1]);
        int second = Integer.parseInt(strings[2]);
        /*if (hour == 11 ){
            return true;
        }*/
        return true;
    }
}
