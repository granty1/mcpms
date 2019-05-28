package com.mcpms.mcpms.system.service.base.impl;

import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MPartProcessMapper;
import com.mcpms.mcpms.system.mapper.base.MProcessCustomMapper;
import com.mcpms.mcpms.system.mapper.base.MProcessMapper;
import com.mcpms.mcpms.system.pojo.base.MPartProcess;
import com.mcpms.mcpms.system.pojo.base.MPartProcessExample;
import com.mcpms.mcpms.system.pojo.base.MProcess;
import com.mcpms.mcpms.system.service.base.MProcessService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * serviceimpl 工序管理
 * @author yuhong
 * @date   2019/1/16
 **/
@Service
@Transactional
public class MProcessServiceImpl implements MProcessService {

    @Autowired
    private MProcessMapper mProcessMapper;
    @Autowired
    private MProcessCustomMapper mProcessCustomMapper;
    @Autowired
    MPartProcessMapper mPartProcessMapper;

    @Override
    public Result getAll() {
        List<MProcess> list = mProcessCustomMapper.getAllOrderBySort();
        return ResponseUtils.responseSuccess(list);
    }

    @Override
    public Result del(long id) {
        MProcess mProcess = mProcessMapper.selectByPrimaryKey(id);
        if(mProcess!=null){

            MPartProcessExample mPartProcessExample = new MPartProcessExample();
            MPartProcessExample.Criteria criteria = mPartProcessExample.createCriteria();
            criteria.andProcessIdEqualTo(mProcess.getId());
            List<MPartProcess> mPartProcesses = mPartProcessMapper.selectByExample(mPartProcessExample);
            if(mPartProcesses.size() == 0){

                mProcessMapper.deleteByPrimaryKey(id);
                return ResponseUtils.responseSuccess();
            }else {
                return ResponseUtils.responseFail("该工序已经被零件使用！无法删除");
            }
        }else{
            return ResponseUtils.responseFail(ResponseInfo.PROCESSNOTEXIST);
        }
    }

    @Override
    public Result batchDel(long[] ids) {

        if(ids.length == 0){
            return ResponseUtils.responseFail(ResponseInfo.LIEASTONE);
        }

        int successdeldata = 0;
        int faildeletedata = 0;
        for(int i=0;i<ids.length;i++){
            MProcess mProcess = mProcessMapper.selectByPrimaryKey(ids[i]);
            if(mProcess!=null){

                MPartProcessExample mPartProcessExample = new MPartProcessExample();
                MPartProcessExample.Criteria criteria = mPartProcessExample.createCriteria();
                criteria.andProcessIdEqualTo(mProcess.getId());
                List<MPartProcess> mPartProcesses = mPartProcessMapper.selectByExample(mPartProcessExample);
                if(mPartProcesses.size() == 0){
                    mProcessMapper.deleteByPrimaryKey(ids[i]);
                    successdeldata++;
                }else{
                    faildeletedata++;
                }

            }else{
                faildeletedata++;
            }

        }
        return ResponseUtils.responseSuccess("删除"+successdeldata+"条记录； "+"失败"+faildeletedata+"条记录。");
    }

    @Override
    public Result findOne(long id) {
        MProcess MProcess = mProcessMapper.selectByPrimaryKey(id);
        if(MProcess!=null){
            return ResponseUtils.responseSuccess(MProcess);
        }else{
            return ResponseUtils.responseFail(ResponseInfo.PROCESSNOTEXIST);
        }
    }

    @Override
    public Result update(MProcess mProcess) {
        if(StringUtils.isEmpty(mProcess.getName()) || mProcess.getSort() == null){
            return ResponseUtils.responseFail(ResponseInfo.INFOMUSTFULL);
        }

        MProcess mProcessData = mProcessMapper.selectByPrimaryKey(mProcess.getId());
        if(mProcessData!=null){
            mProcessMapper.updateByPrimaryKey(mProcess);
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail(ResponseInfo.PROCESSNOTEXIST);
        }
    }

    @Override
    public Result add(MProcess mProcess) {
        if(StringUtils.isEmpty(mProcess.getName()) || mProcess.getSort() == null){
            return ResponseUtils.responseFail(ResponseInfo.INFOMUSTFULL);
        }

        mProcess.setId(IDUtils.genItemId());
        mProcessMapper.insert(mProcess);
        return ResponseUtils.responseSuccess();
    }
}
