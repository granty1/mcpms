package com.mcpms.mcpms.system.service.base.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MOutMapper;
import com.mcpms.mcpms.system.mapper.base.MPartProcessMapper;
import com.mcpms.mcpms.system.pojo.base.MOut;
import com.mcpms.mcpms.system.pojo.base.MOutExample;
import com.mcpms.mcpms.system.pojo.base.MPartProcess;
import com.mcpms.mcpms.system.pojo.base.MPartProcessExample;
import com.mcpms.mcpms.system.service.base.MOutService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * serviceimpl 外协管理
 * @author yuhong
 * @date   2019/2/24
 **/
@Service
@Transactional
public class MOutServiceImpl implements MOutService {

    @Autowired
    private MOutMapper mOutMapper;
    @Autowired
    private MPartProcessMapper mPartProcessMapper;

    @Override
    public Result getAll(MOut mOut,Integer page, Integer size) {

        MOutExample mOutExample = new MOutExample();
        MOutExample.Criteria criteria = mOutExample.createCriteria();
        List<MOut> list;
        criteria.andIdNotEqualTo(218L);
        PageHelper.startPage(page, size);
        if(StringUtils.isEmpty(mOut.getName()) & StringUtils.isEmpty(mOut.getPerson())){
            list = mOutMapper.selectByExample(mOutExample);
        }else if(StringUtils.isEmpty(mOut.getName())){
            criteria.andPersonLike("%"+mOut.getPerson()+"%");
            list = mOutMapper.selectByExample(mOutExample);
        }else if(StringUtils.isEmpty(mOut.getPerson())){
            criteria.andNameLike("%"+mOut.getName()+"%");
            list = mOutMapper.selectByExample(mOutExample);
        }else{
            criteria.andPersonLike("%"+mOut.getPerson()+"%").andNameLike("%"+mOut.getName()+"%");
            list = mOutMapper.selectByExample(mOutExample);
        }
        PageInfo<MOut> pageInfo=new PageInfo<MOut>(list);


        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }


    @Override
    public Result del(long id) {
        MOut mOut = mOutMapper.selectByPrimaryKey(id);
        if(mOut!=null){
            MPartProcessExample example = new MPartProcessExample();
            MPartProcessExample.Criteria criteria = example.createCriteria();
            criteria.andOutIdEqualTo(id);
            List<MPartProcess> processList = mPartProcessMapper.selectByExample(example);
            if (processList.size()>0){
                return ResponseUtils.responseFail("该外协单位已经处于使用中");
            }
            mOutMapper.deleteByPrimaryKey(id);
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail(ResponseInfo.OUTNOTEXIST);
        }
    }

    @Override
    public Result findOne(long id) {
        MOut mOut = mOutMapper.selectByPrimaryKey(id);
        if(mOut!=null){
            return ResponseUtils.responseSuccess(mOut);
        }else{
            return ResponseUtils.responseFail(ResponseInfo.OUTNOTEXIST);
        }
    }

    @Override
    public Result update(MOut mOut) {
        if(mOut.getId()==null){
            return ResponseUtils.responseFail(ResponseInfo.UNKOWNERROR);
        }
        if(StringUtils.isEmpty(mOut.getName())){
            return ResponseUtils.responseFail(ResponseInfo.OUTNEEDNAME);
        }

        MOut mOutData = mOutMapper.selectByPrimaryKey(mOut.getId());
        if(mOutData!=null){
            mOutMapper.updateByPrimaryKey(mOut);
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail(ResponseInfo.OUTEXIST);
        }


    }

    @Override
    public Result add(MOut mOut) {
        if(StringUtils.isEmpty(mOut.getName())){
            return ResponseUtils.responseFail(ResponseInfo.OUTNEEDNAME);
        }

        mOut.setId(IDUtils.genItemId());
        mOutMapper.insert(mOut);
        return ResponseUtils.responseSuccess();
    }
}
