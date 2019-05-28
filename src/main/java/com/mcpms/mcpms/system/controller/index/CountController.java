package com.mcpms.mcpms.system.controller.index;


import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MCountMapper;
import com.mcpms.mcpms.system.pojo.vo.CountBaseData;
import com.mcpms.mcpms.system.pojo.vo.MonthCount;
import com.mcpms.mcpms.system.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
* count controller
* @class  CountController
* @author guolin
* @date   2019/2/27/027
**/
@RestController
public class CountController {

    private static final String INTRO_FLAG = "intro_flag";

    private static final String TRUE = "true";

    @Autowired
    private MCountMapper mCountMapper;

    @GetMapping("/count/monthdata")
    public int[] monthData(){
        List<MonthCount> monthCount = mCountMapper.findMonthCount(DateUtils.getYear());
        int[] monthsData = new int[12];

        for (MonthCount month :
                monthCount) {
            monthsData[month.getMonth()-1] = month.getNum();
        }
        return monthsData;
    }

    @GetMapping("/count/basedata")
    public Result baseData(){
        return ResponseUtils.responseSuccess(new CountBaseData(mCountMapper.orderTotalNums(),
                mCountMapper.orderRunningNums(),
                mCountMapper.notApprovalPlanNums(),
                mCountMapper.runningApprovalPlanNums(),
                mCountMapper.outProcessNum(),
                mCountMapper.outWarningNums()));
    }

    @GetMapping("/intro/isdo")
    public Result isDoIntroJS(HttpSession session){
        String intro_flag = (String) session.getAttribute(INTRO_FLAG);
        if(StringUtils.isEmpty(intro_flag)){
            session.setAttribute(INTRO_FLAG,TRUE);
            return ResponseUtils.responseSuccess(true);
        }else{
            return ResponseUtils.responseSuccess(false);
        }
    }

}
