package com.mcpms.mcpms.system.service.base.impl;

import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.*;
import com.mcpms.mcpms.system.mapper.produce.VProductPartProcessPlanMapper;
import com.mcpms.mcpms.system.pojo.base.*;
import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlanExample;
import com.mcpms.mcpms.system.service.base.MPartProcessService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 零件工序管理
 * @author yuhong
 * @date   2019/1/16
 **/
@Service
@Transactional
public class MPartProcessServiceImpl implements MPartProcessService {

    @Autowired
    MPartProcessMapper mPartProcessMapper;

    @Autowired
    MPartProcessCustomMapper mPartProcessCustomMapper;

    @Autowired
    MModeMapper mModeMapper;
    
    @Autowired
    MOutMapper mOutMapper;
    
    @Autowired
    MProcessMapper mProcessMapper;
    @Autowired
    VProductPartProcessPlanMapper vProductPartProcessPlanMapper;
    @Autowired
    MPartMapper mPartMapper;


    @Override
    public Result getAllByPartId(Long partsId) {
        List<MPartProcessVo> list = mPartProcessCustomMapper.getAllByPartIdDesc(partsId);
        return ResponseUtils.responseSuccess(list);
    }

    @Override
    public Result del(long ids) {
        mPartProcessMapper.deleteByPrimaryKey(ids);
        return ResponseUtils.responseSuccess();
    }

    @Override
    public Result findOne(long id) {
        MPartProcess mPartProcess = mPartProcessMapper.selectByPrimaryKey(id);
        if(mPartProcess!=null){
            return ResponseUtils.responseSuccess(mPartProcess);
        }else{
            return ResponseUtils.responseFail(ResponseInfo.PARTPROCESSNOTEXIST);
        }
    }

    @Override
    public Result update(MPartProcess mPartProcess) {

        if (mPartProcess.getDay()==null){
            return ResponseUtils.responseFail("优先级将决定零件工序的执行顺序，请填写");
        }

        if(mPartProcess.getProcessId() == null){
            return ResponseUtils.responseFail(ResponseInfo.PARTPROCESSIDNEEDFULL);
        }

        if(mPartProcess.getModeId()!=null){
            if(mPartProcess.getModeId() == 1){
                mPartProcess.setOutId(null);
            }
        }

        MPartProcessExample example = new MPartProcessExample();
        MPartProcessExample.Criteria criteria1 = example.createCriteria();
        criteria1.andPartsIdEqualTo(mPartProcess.getPartsId());
        criteria1.andDayEqualTo(mPartProcess.getDay());
        List<MPartProcess> mPartProcesses = mPartProcessMapper.selectByExample(example);
        if (mPartProcesses.size()>1){
            return ResponseUtils.responseFail("优先级重复，请重新设置");
        }


        MPartProcess mPartProcessData = mPartProcessMapper.selectByPrimaryKey(mPartProcess.getId());
        if(mPartProcessData!=null){

            if(mPartProcess.getProcessId().equals(mPartProcessData.getProcessId())){
                //如果没有更改工序
                mPartProcessMapper.updateByPrimaryKey(mPartProcess);
                return ResponseUtils.responseSuccess();
            }else{
                //工序被修改
                MPartProcessExample mPartProcessExample = new MPartProcessExample();
                MPartProcessExample.Criteria criteria = mPartProcessExample.createCriteria();
                criteria.andPartsIdEqualTo(mPartProcess.getPartsId()).andProcessIdEqualTo(mPartProcess.getProcessId());

                List<MPartProcess> list = mPartProcessMapper.selectByExample(mPartProcessExample);

                if(list.size() == 0){
                    mPartProcessMapper.updateByPrimaryKey(mPartProcess);
                    return ResponseUtils.responseSuccess();
                }else{
                    return ResponseUtils.responseFail(ResponseInfo.PARTPROCESSEXIST);
                }
            }


        }else{
            return ResponseUtils.responseFail(ResponseInfo.PARTPROCESSNOTEXIST);
        }
    }

    @Override
    public Result add(MPartProcess mPartProcess) {

        if (mPartProcess.getDay()==null){
            return ResponseUtils.responseFail("优先级将决定零件工序的执行顺序，请填写");
        }

        if(mPartProcess.getProcessId() == null){
            return ResponseUtils.responseFail(ResponseInfo.PARTPROCESSIDNEEDFULL);
        }

        MPartProcessExample mPartProcessExample = new MPartProcessExample();
        MPartProcessExample.Criteria criteria = mPartProcessExample.createCriteria();
        criteria.andPartsIdEqualTo(mPartProcess.getPartsId()).andProcessIdEqualTo(mPartProcess.getProcessId());

        List<MPartProcess> list = mPartProcessMapper.selectByExample(mPartProcessExample);

        if(list.size() == 0){
            if(mPartProcess.getModeId() !=null){
                if(mPartProcess.getModeId() == 1){
                    mPartProcess.setOutId(null);
                }
            }

            mPartProcess.setId(IDUtils.genItemId());
            mPartProcessMapper.insert(mPartProcess);
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail(ResponseInfo.PARTPROCESSEXIST);
        }

    }

    @Override
    public Result initData() {
        List<MMode> methodList = mModeMapper.selectByExample(null);
        List<MOut> outList = mOutMapper.selectByExample(null);
        List<MProcess> processList = mProcessMapper.selectByExample(null);

        Map map = new HashMap();
        map.put("methodList",methodList);
        map.put("outList",outList);
        map.put("processList",processList);

        return ResponseUtils.responseSuccess(map);

    }

    @Override
    public Result clone(long id,long targitId) {


        /*清空之前零件的所有工序*/
        MPartProcessExample mPartProcessExample1 = new MPartProcessExample();
        MPartProcessExample.Criteria criteria1 = mPartProcessExample1.createCriteria();
        criteria1.andPartsIdEqualTo(id);
        mPartProcessMapper.deleteByExample(mPartProcessExample1);

        MPartProcessExample mPartProcessExample = new MPartProcessExample();
        MPartProcessExample.Criteria criteria = mPartProcessExample.createCriteria();
        criteria.andPartsIdEqualTo(targitId);
        /*查出目标id的零件工序列表*/
        List<MPartProcess> mPartProcesses = mPartProcessMapper.selectByExample(mPartProcessExample);

        if(mPartProcesses.size() == 0){
            return ResponseUtils.responseFail("目标零件还没有工序！");
        }

        for(int i=0;i<mPartProcesses.size();i++){
            MPartProcess mPartProcess = mPartProcesses.get(i);
            mPartProcess.setPartsId(id);
            mPartProcess.setId(IDUtils.genItemId());
            mPartProcessMapper.insert(mPartProcess);
        }
        return ResponseUtils.responseSuccess("克隆成功！");
    }

    public static boolean isNumber(String str) {
        //采用正则表达式的方式来判断一个字符串是否为数字，这种方式判断面比较全
        // 可以判断正负、整数小数
        boolean isInt = Pattern.compile("^-?[1-9]\\d*$").matcher(str).find();
        boolean isDouble = Pattern.compile("^-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)$").matcher(str).find();
        return isInt || isDouble;
    }
}
