package com.mcpms.mcpms.system.service.base.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.newplan.mapper.produce.NewMPartPlanMapper;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlan;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanExample;
import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MPartMapper;
import com.mcpms.mcpms.system.mapper.base.MPartProcessMapper;
import com.mcpms.mcpms.system.mapper.base.MProductPartMapper;
import com.mcpms.mcpms.system.pojo.base.*;
import com.mcpms.mcpms.system.service.base.MPartService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * serviceimpl 零件管理
 *
 * @author yuhong
 * @date 2019/1/16
 **/
@Service
@Transactional
public class MPartServiceImpl implements MPartService {

    @Autowired
    private MPartMapper mPartMapper;
    @Autowired
    private MProductPartMapper mProductPartMapper;
    @Autowired
    private MPartProcessMapper mPartProcessMapper;
    @Autowired
    private NewMPartPlanMapper newMPartPlanMapper;

    @Override
    public Result getAll(MPart mPart, Integer page, Integer size) {

        List<MPart> list;
        PageHelper.startPage(page, size);
        if (StringUtils.isEmpty(mPart.getName()) & StringUtils.isEmpty(mPart.getDrawingNum()) & StringUtils.isEmpty(mPart.getPartNum())) {
            list = mPartMapper.selectByExample(null);
        } else {
            MPartExample mPartExample = new MPartExample();
            MPartExample.Criteria criteria = mPartExample.createCriteria();

            if (!StringUtils.isEmpty(mPart.getName())) {
                criteria.andNameLike("%" + mPart.getName() + "%");
            }
            if (!StringUtils.isEmpty(mPart.getPartNum())) {
                criteria.andPartNumLike("%" + mPart.getPartNum() + "%");
            }
            if (!StringUtils.isEmpty(mPart.getDrawingNum())) {
                criteria.andDrawingNumLike("%" + mPart.getDrawingNum() + "%");
            }
            list = mPartMapper.selectByExample(mPartExample);
        }
        PageInfo<MPart> pageInfo = new PageInfo<MPart>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }

    private boolean isSatis(long id) {
        NewMPartPlanExample example = new NewMPartPlanExample();
        NewMPartPlanExample.Criteria criteria = example.createCriteria();
        criteria.andPartIdEqualTo(id);
        List<NewMPartPlan> newMPartPlans = newMPartPlanMapper.selectByExample(example);
        if (newMPartPlans.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Result del(long[] ids) {
        int count = 0;
        for (long id :
                ids) {
            if (isSatis(id)) {
                try {
                    mPartMapper.deleteByPrimaryKey(id);
                    MPartProcessExample processExample = new MPartProcessExample();
                    MPartProcessExample.Criteria criteria = processExample.createCriteria();
                    criteria.andPartsIdEqualTo(id);
                    mPartProcessMapper.deleteByExample(processExample);
                    count++;
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }

        String msg = "共 <strong>" + ids.length + "</strong>条记录，删除成功<strong>" + count + "</strong>条。";
        if (ids.length!=count){
            msg+="失败原因：<strong>零件已经建立了生成计划</strong>。";
        }
        return ResponseUtils.responseSuccess(msg);
    }

    @Override
    public Result findOne(long id) {
        MPart mPart = mPartMapper.selectByPrimaryKey(id);
        if (mPart != null) {
            return ResponseUtils.responseSuccess(mPart);
        } else {
            return ResponseUtils.responseFail(ResponseInfo.PARTNOTEXIST);
        }
    }

    @Override
    public Result update(MPart mPart) {

        if (StringUtils.isEmpty(mPart.getPartNum())) {
            return ResponseUtils.responseFail(ResponseInfo.PARTNEEDNUM);
        }

        MPart mPartData = mPartMapper.selectByPrimaryKey(mPart.getId());
        if (mPartData != null) {

            if (mPart.getPartNum().trim().equals(mPartData.getPartNum())) {
                //如果没有更改零件编号
                mPartMapper.updateByPrimaryKey(mPart);
                return ResponseUtils.responseSuccess();
            } else {
                //零件编号被修改
                MPartExample mPartExample = new MPartExample();
                MPartExample.Criteria criteria = mPartExample.createCriteria();
                criteria.andPartNumEqualTo(mPart.getPartNum());

                List<MPart> list = mPartMapper.selectByExample(mPartExample);

                if (list.size() == 0) {
                    mPartMapper.updateByPrimaryKey(mPart);
                    return ResponseUtils.responseSuccess();
                } else {
                    return ResponseUtils.responseFail(ResponseInfo.PARTNUMEXIST);
                }
            }


        } else {
            return ResponseUtils.responseFail(ResponseInfo.PARTNOTEXIST);
        }
    }

    @Override
    public Result add(MPart mPart) {
        if (StringUtils.isEmpty(mPart.getPartNum())) {
            return ResponseUtils.responseFail(ResponseInfo.PARTNEEDNUM);
        }

        MPartExample mPartExample = new MPartExample();
        MPartExample.Criteria criteria = mPartExample.createCriteria();
        criteria.andPartNumEqualTo(mPart.getPartNum());

        List<MPart> list = mPartMapper.selectByExample(mPartExample);

        if (list.size() == 0) {
            mPart.setId(IDUtils.genItemId());
            mPartMapper.insert(mPart);
            return ResponseUtils.responseSuccess();
        } else {
            return ResponseUtils.responseFail(ResponseInfo.PARTNUMEXIST);
        }


    }
}
