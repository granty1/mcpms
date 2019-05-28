package com.mcpms.mcpms.warning;

import com.mcpms.mcpms.system.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class Timer implements Runnable{

    private static final Logger log = LoggerFactory.getLogger(Timer.class);

    private static long ONE_HOUR = 1000 * 60 * 60;

    private static long ONE_MINUTE = 1000 * 60;

    private static long FIVE_MINUTE = 5000 * 60;


    private DailyWarning dailyWarning;

    public Timer(DailyWarning dailyWarning){
        this.dailyWarning = dailyWarning;
    }


    @Override
public void run() {
    while(true){
        if(TimeMonitor.isSatisfied(DateUtils.getTime())){
            dailyWarning.doWarning();
        }
        try{
            log.info("Timer is running ,time:"+DateUtils.getTime());
            Thread.sleep(FIVE_MINUTE);
        }catch(Exception e){
            log.error("Thread error");
        }
    }
}
}
