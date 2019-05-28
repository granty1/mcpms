package com.mcpms.mcpms.newplan.service.produce.impl;

import com.mcpms.mcpms.newplan.mapper.produce.NewMPartPlanMapper;
import com.mcpms.mcpms.newplan.mapper.produce.NewMPartPlanProcessMapper;
import com.mcpms.mcpms.newplan.mapper.produce.VPartPlanProcessMapper;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlan;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanProcess;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlanProcess;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlanProcessExample;
import com.mcpms.mcpms.newplan.service.produce.PartPlanService;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MPartProcessCustomMapper;
import com.mcpms.mcpms.system.mapper.base.MPartProcessMapper;
import com.mcpms.mcpms.system.pojo.base.*;
import com.mcpms.mcpms.system.utils.DateUtils;
import com.mcpms.mcpms.system.utils.IDUtils;
import com.mcpms.mcpms.system.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PartPlanServiceImpl implements PartPlanService {


    @Autowired
    private NewMPartPlanMapper newMPartPlanMapper;
    @Autowired
    private NewMPartPlanProcessMapper newMPartPlanProcessMapper;
    @Autowired
    private MPartProcessMapper mPartProcessMapper;
    @Autowired
    private MPartProcessCustomMapper mPartProcessCustomMapper;
    @Autowired
    private VPartPlanProcessMapper vPartPlanProcessMapper;

    @Override
    public Result createPlan(ArrayList<InserOrderObj> list,String batchNum) {

        boolean flag = true;
        String msg = "目标零件中：";
        for (InserOrderObj inserOrderObj :
                list) {
            if (inserOrderObj.getNum() <= 0) {
                return ResponseUtils.responseFail("零件数量不能小于等于0");
            }
            if (!hasProcess(inserOrderObj.getId())){
                flag = false;
                msg += "<strong>"+inserOrderObj.getName()+"</strong> ";
            }
        }

        msg += "暂未添加工序，无法建立生产计划";

        if (!flag){
            return ResponseUtils.responseFail(msg);
        }

        for (InserOrderObj inserOrderObj :
                list) {
            NewMPartPlan plan = new NewMPartPlan();

            long planId = IdWorker.getId();
            plan.setId(planId);
            plan.setPartId(inserOrderObj.getId());
            plan.setNum(inserOrderObj.getNum());
            plan.setCurrentProcessId(218L);
            plan.setPlanStatus(11L);
            plan.setRunNum(batchNum);
            plan.setCreateTime(DateUtils.getTime());

            //获取零件对应的工序列表
            List<MPartProcessVo> processList = mPartProcessCustomMapper.getAllByPartIdDesc(inserOrderObj.getId());

            //遍历零件-工序列表  添加 生产计划工序

            for (int i = 1; i <= processList.size(); i++) {
                MPartProcessVo modelProcess = processList.get(i - 1);
                NewMPartPlanProcess process = new NewMPartPlanProcess();
                long id = IdWorker.getId();
                process.setId(id);
                System.out.println(id);
                process.setPartPlanId(planId);
                process.setPartProcessId(modelProcess.getId());

                if (modelProcess.getModeId() != null) {
                    process.setProcessModeId(modelProcess.getModeId());
                } else {
                    process.setProcessModeId(218L);
                }
                if (modelProcess.getOutId() != null) {
                    process.setOutId(modelProcess.getOutId());
                } else {
                    process.setOutId(218L);
                }
                process.setPartDrawingNum(modelProcess.getDrawingNum());
                process.setPrice(modelProcess.getPrice());

                process.setPlanProcessStatus(11L);
                process.setDoSort(i);
                newMPartPlanProcessMapper.insert(process);
            }
            newMPartPlanMapper.insert(plan);
        }
        return ResponseUtils.responseSuccess("创建成功");
    }


    @Override
    public Result circult(long id) {

        NewMPartPlan plan = newMPartPlanMapper.selectByPrimaryKey(id);

        List<VPartPlanProcess> processList = getProcessList(id);

        if (processList.size() != 0) {
            if (processList.get(0).getPlanProcessStatus().equals(11L) &&
                    plan.getCurrentProcessId().equals(218L)) {
                // 执行第一道工序

                VPartPlanProcess vfirstProcess = processList.get(0);
                NewMPartPlanProcess firstProcess = newMPartPlanProcessMapper.selectByPrimaryKey(vfirstProcess.getId());
                // 将当前计划状态改为 执行
                plan.setPlanStatus(12L);
                // 当前计划的 当前工序 设为 第一道工序
                plan.setCurrentProcessId(vfirstProcess.getProcessId());
                // 将第一道工序状态设为 执行
                firstProcess.setPlanProcessStatus(12L);
                firstProcess.setTurnOutTime(DateUtils.getTime());

                newMPartPlanMapper.updateByPrimaryKey(plan);
                newMPartPlanProcessMapper.updateByPrimaryKey(firstProcess);
                String msg = "已执行第一道工序 : <strong> " + vfirstProcess.getProcessName() + " </strong>";
                return ResponseUtils.responseSuccess(msg);
            } else if (processList.get(processList.size() - 1).getPlanProcessStatus().equals(12L)) {
                // 最后一道执行完

                BigDecimal totalPrice = new BigDecimal(0);

                VPartPlanProcess vlastProcess = processList.get(processList.size() - 1);
                NewMPartPlanProcess lastProcess = newMPartPlanProcessMapper.selectByPrimaryKey(vlastProcess.getId());
                // 将最后一道工序状态 设为 完成 ， 填充当前工序信息
                lastProcess.setPlanProcessStatus(13L);
                lastProcess.setActualFinishTime(DateUtils.getTime());
                try {
                    lastProcess.setDays(DateUtils.getDatePoor(lastProcess.getTurnOutTime(), lastProcess.getActualFinishTime()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //计算总价

                for (VPartPlanProcess vPartPlanProcess :
                        processList) {
                    if (vPartPlanProcess.getPrice()!=null){
                        totalPrice = totalPrice.add(vPartPlanProcess.getPrice());
                    }
                }
                // 修改 计划 当前状态、当前工序、实际完成时间、总价
                plan.setPlanStatus(13L);
                plan.setPrice(totalPrice);
                plan.setActualFinishTime(DateUtils.getTime());
                plan.setCurrentProcessId(219L);
                newMPartPlanProcessMapper.updateByPrimaryKey(lastProcess);
                newMPartPlanMapper.updateByPrimaryKey(plan);
                String msg = "最后一道工序：<strong>" + vlastProcess.getProcessName() + "</strong>完成，该零件工序已全部完成";
                return ResponseUtils.responseSuccess(msg);
            } else {
                // 结束上一道，执行下一道
                long currentId = 0L;
                long nextId = 0L;
                long nextProcessId = 0L;

                String currentName = "";
                String nextName = "";

                for (int i = 0; i < processList.size(); i++) {
                    if (processList.get(i).getProcessId().equals(plan.getCurrentProcessId())) {
                        currentId = processList.get(i).getId();
                        currentName = processList.get(i).getProcessName();
                        nextId = processList.get(i + 1).getId();
                        nextProcessId = processList.get(i + 1).getProcessId();
                        nextName = processList.get(i + 1).getProcessName();
                    }
                }
                NewMPartPlanProcess currentProcess = newMPartPlanProcessMapper.selectByPrimaryKey(currentId);
                NewMPartPlanProcess nextProcess = newMPartPlanProcessMapper.selectByPrimaryKey(nextId);
                // 完善上一道工序 信息
                currentProcess.setActualFinishTime(DateUtils.getTime());
                try {
                    currentProcess.setDays(DateUtils.getDatePoor(currentProcess.getTurnOutTime(), currentProcess.getActualFinishTime()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                currentProcess.setPlanProcessStatus(13L);
                // 更新 计划中的当前工序
                plan.setCurrentProcessId(nextProcessId);
                // 修改下一道工序
                nextProcess.setTurnOutTime(DateUtils.getTime());
                nextProcess.setPlanProcessStatus(12L);
                newMPartPlanMapper.updateByPrimaryKeySelective(plan);
                newMPartPlanProcessMapper.updateByPrimaryKeySelective(currentProcess);
                newMPartPlanProcessMapper.updateByPrimaryKeySelective(nextProcess);
                String msg = "完成上一道工序：<strong>" + currentName + "</strong>，执行下一道工序：<strong>" + nextName + "</strong>";
                return ResponseUtils.responseSuccess(msg);
            }
        }
        return ResponseUtils.responseFail("该零件未录入工序");
    }


    @Override
    public Result preCirclue(long id) {

        NewMPartPlan plan = newMPartPlanMapper.selectByPrimaryKey(id);

        List<VPartPlanProcess> processList = getProcessList(id);

        if (processList.size() == 0) {
            return ResponseUtils.responseCustom(218, "该零件尚未录入工序", null);
        }

        if (!plan.getCurrentProcessId().equals(218L)&& processList.size()==1){
            return ResponseUtils.responseSuccess();
        }

        int sort = 0;

        VPartPlanProcess nextProcess;


        if (processList.get(processList.size() - 1).getPlanProcessStatus().equals(12L)) {
            return ResponseUtils.responseSuccess();
        } else {
            if (plan.getCurrentProcessId().equals(218L)) {
                nextProcess = processList.get(0);
            } else {
                for (VPartPlanProcess vPartPlanProcess :
                        processList) {
                    Long processId = vPartPlanProcess.getProcessId();
                    Long currentProcessId = plan.getCurrentProcessId();
                    if (processId.equals(currentProcessId)) {
                        sort = vPartPlanProcess.getDoSort();
                    }
                }
                nextProcess = processList.get(sort);
            }
        }

        boolean flag = true;

        String message = "下一道工序中， <strong>";

        if (nextProcess.getProcessModeId() == null || nextProcess.getProcessModeId().equals(218L)) {
            message += "加工方式 ";
            flag = false;
        }
        if (!nextProcess.getProcessModeId().equals(1L) &&
                (nextProcess.getOutId() == null || nextProcess.getOutId().equals(218L))) {
            message += "外协单位 ";
            flag = false;
        }
        if (StringUtils.isEmpty(nextProcess.getPlanFinishTime())) {
            message += "计划完成时间 ";
            flag = false;
        }
        if (nextProcess.getPrice() == null) {
            message += "单价";
            flag = false;
        }

        message += " </strong>尚未编辑，确认不编辑直接流转吗？";

        if (flag) {
            return ResponseUtils.responseSuccess();
        } else {
            return ResponseUtils.responseFail(message);
        }
    }

    private List<VPartPlanProcess> getProcessList(long id) {
        VPartPlanProcessExample example = new VPartPlanProcessExample();
        VPartPlanProcessExample.Criteria criteria = example.createCriteria();
        criteria.andPartPlanIdEqualTo(id);
        List<VPartPlanProcess> processList = vPartPlanProcessMapper.selectByExample(example);
        return processList;
    }

    private boolean hasProcess(long partId){
        MPartProcessExample example = new MPartProcessExample();
        MPartProcessExample.Criteria criteria = example.createCriteria();
        criteria.andPartsIdEqualTo(partId);
        List<MPartProcess> processList = mPartProcessMapper.selectByExample(example);
        if (processList.size()>0){
            return true;
        }
        return false;
    }
}
