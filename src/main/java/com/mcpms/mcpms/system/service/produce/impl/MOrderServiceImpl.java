package com.mcpms.mcpms.system.service.produce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.produce.MOrderMapper;
import com.mcpms.mcpms.system.mapper.produce.MProductPartPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.VOrderMapper;
import com.mcpms.mcpms.system.mapper.produce.VProductPartPlanMapper;
import com.mcpms.mcpms.system.pojo.produce.*;
import com.mcpms.mcpms.system.service.produce.MOrderService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 订单管理
 * @author yuhong
 * @date   2019/1/16
 **/
@Service
@Transactional
public class MOrderServiceImpl implements MOrderService {
    
    @Autowired
    MOrderMapper mOrderMapper;
    @Autowired
    VOrderMapper vOrderMapper;
    @Autowired
    VProductPartPlanMapper vProductPartPlanMapper;
    @Autowired
    MProductPartPlanMapper mProductPartPlanMapper;
    
    @Override
    public Result getAll(MOrder mOrder, Integer page, Integer size) {
        List<VOrder> list;
        PageHelper.startPage(page, size);
        if(mOrder==null){
            list = vOrderMapper.selectByExample(null);
        }else{
            if(StringUtils.isEmpty(mOrder.getOrderNum()) & mOrder.getStatus() == 0){
                list = vOrderMapper.selectByExample(null);
            }else{
                VOrderExample vOrderExample = new VOrderExample();
                VOrderExample.Criteria criteria = vOrderExample.createCriteria();

                if(!StringUtils.isEmpty(mOrder.getOrderNum())){
                    criteria.andOrderNumLike("%"+mOrder.getOrderNum()+"%");
                }
                if(mOrder.getStatus() != 0){
                    criteria.andStatusEqualTo(mOrder.getStatus());
                }
                list = vOrderMapper.selectByExample(vOrderExample);
            }
        }

        PageInfo<VOrder> pageInfo=new PageInfo<VOrder>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Result del(long[] ids) {
        if(ids.length == 0){
            return ResponseUtils.responseFail(ResponseInfo.LIEASTONE);
        }

        int successdeldata = 0;
        int faildeletedata = 0;
        for(int i=0;i<ids.length;i++){
            MOrder mOrder = mOrderMapper.selectByPrimaryKey(ids[i]);
            if(mOrder!=null){
                mOrder.setStatus(53);
                mOrderMapper.updateByPrimaryKey(mOrder);
                successdeldata++;
            }else{
                faildeletedata++;
            }

        }
        if(ids.length == 1){
            if(successdeldata == 1){
                return ResponseUtils.responseSuccess();
            }else{
                return ResponseUtils.responseFail(ResponseInfo.CANNOTDEL);
            }
        }else{
            return ResponseUtils.responseSuccess("删除"+successdeldata+"条记录； "+" 失败"+faildeletedata+"条记录。");
        }
    }

    @Override
    public Result findOne(long id) {
        MOrder mOrder = mOrderMapper.selectByPrimaryKey(id);
        if(mOrder!=null){
            return ResponseUtils.responseSuccess(mOrder);
        }else{
            return ResponseUtils.responseFail(ResponseInfo.ORDERNOTEXIST);
        }
    }

    @Override
    public Result update(MOrder mOrder) {
        if(StringUtils.isEmpty(mOrder.getOrderNum())){
            return ResponseUtils.responseFail(ResponseInfo.ORDERNEEDNUM);
        }

        MOrder mOrderData = mOrderMapper.selectByPrimaryKey(mOrder.getId());
        if(mOrderData!=null){

            if(mOrder.getOrderNum().trim().equals(mOrderData.getOrderNum())){
                //如果没有更改订单编号
                mOrderMapper.updateByPrimaryKey(mOrder);
                return ResponseUtils.responseSuccess();
            }else{
                //订单编号被修改
                MOrderExample mOrderExample = new MOrderExample();
                MOrderExample.Criteria criteria = mOrderExample.createCriteria();
                criteria.andOrderNumEqualTo(mOrder.getOrderNum());

                List<MOrder> list = mOrderMapper.selectByExample(mOrderExample);

                if(list.size() == 0){
                    mOrderMapper.updateByPrimaryKey(mOrder);
                    return ResponseUtils.responseSuccess();
                }else{
                    return ResponseUtils.responseFail(ResponseInfo.ORDERNUMEXIST);
                }
            }


        }else{
            return ResponseUtils.responseFail(ResponseInfo.ORDERNOTEXIST);
        }
    }

    @Override
    public Result add(MOrder mOrder) {
        if(StringUtils.isEmpty(mOrder.getOrderNum())){
            return ResponseUtils.responseFail(ResponseInfo.ORDERNEEDNUM);
        }

        MOrderExample mOrderExample = new MOrderExample();
        MOrderExample.Criteria criteria = mOrderExample.createCriteria();
        criteria.andOrderNumEqualTo(mOrder.getOrderNum());

        List<MOrder> list = mOrderMapper.selectByExample(mOrderExample);

        if(list.size() == 0){
            mOrder.setId(IDUtils.genItemId());
            mOrder.setStatus(51);
            mOrderMapper.insert(mOrder);
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail(ResponseInfo.ORDERNUMEXIST);
        }
    }

    @Override
    public Result finshorder(long id) {
        MOrder mOrder = mOrderMapper.selectByPrimaryKey(id);
        if(mOrder!=null){
            VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
            VProductPartPlanExample.Criteria criteria = vProductPartPlanExample.createCriteria();
            criteria.andOrderIdEqualTo(id).andStatusNotEqualTo(13).andStatusNotEqualTo(14);
            List<VProductPartPlan> vProductPartPlans = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
            if(vProductPartPlans.size() == 0){
                mOrder.setStatus(52);
                mOrderMapper.updateByPrimaryKey(mOrder);
                return ResponseUtils.responseSuccess();
            }else {
                return ResponseUtils.responseFail("该订单仍然有未结束的生产计划，无法手动完成！");
            }


        }
        return ResponseUtils.responseFail(ResponseInfo.ORDERNOTEXIST);
    }

    @Override
    public Result scrap(long id) {
        VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
        VProductPartPlanExample.Criteria criteria = vProductPartPlanExample.createCriteria();
        criteria.andOrderIdEqualTo(id).andStatusNotEqualTo(13).andStatusNotEqualTo(14);
        List<VProductPartPlan> vProductPartPlans = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
        for (int i = 0; i < vProductPartPlans.size(); i++) {
            VProductPartPlan vProductPartPlan = vProductPartPlans.get(i);
            MProductPartPlan mProductPartPlan = mProductPartPlanMapper.selectByPrimaryKey(vProductPartPlan.getId());
            mProductPartPlan.setStatus(14);
            mProductPartPlanMapper.updateByPrimaryKey(mProductPartPlan);
        }
        MOrder mOrder = mOrderMapper.selectByPrimaryKey(id);
        mOrder.setStatus(53);
        mOrderMapper.updateByPrimaryKey(mOrder);


        return ResponseUtils.responseSuccess("报废成功！");
    }
}
