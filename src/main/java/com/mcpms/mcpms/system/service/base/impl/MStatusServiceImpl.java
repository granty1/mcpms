package com.mcpms.mcpms.system.service.base.impl;

import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MStatusMapper;
import com.mcpms.mcpms.system.pojo.base.MStatus;
import com.mcpms.mcpms.system.pojo.vo.PlanDate;
import com.mcpms.mcpms.system.service.base.MStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MStatusServiceImpl implements MStatusService {

    @Autowired
    MStatusMapper mStatusMapper;


    /*修改计划预警时间*/
    public Result updatePlanTime(PlanDate planDate){
        int planTime,processTime;
        long planId = 81;
        long processId = 82;
        MStatus planStatus = mStatusMapper.selectByPrimaryKey(planId);
        MStatus processStatus = mStatusMapper.selectByPrimaryKey(processId);

        if(planDate!=null){
            planTime = planDate.getPlanDays();
            processTime = planDate.getProcessDays();
            planStatus.setSort(planTime);
            processStatus.setSort(processTime);
            mStatusMapper.updateByPrimaryKey(planStatus);
            mStatusMapper.updateByPrimaryKey(processStatus);
            return ResponseUtils.responseSuccess("设置预警时间成功！");

        }
        return ResponseUtils.responseSuccess("设置预警时间失败！");

    }

    public Result findPlanTime(){
        long planId = 81;
        long processId = 82;
        MStatus planStatus = mStatusMapper.selectByPrimaryKey(planId);
        MStatus processStatus = mStatusMapper.selectByPrimaryKey(processId);

        PlanDate planDate = new PlanDate();
        planDate.setPlanDays(planStatus.getSort());
        planDate.setProcessDays(processStatus.getSort());

        return ResponseUtils.responseSuccess(planDate);
    }


}
