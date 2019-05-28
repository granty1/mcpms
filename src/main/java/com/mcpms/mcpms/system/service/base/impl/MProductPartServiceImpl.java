package com.mcpms.mcpms.system.service.base.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.*;
import com.mcpms.mcpms.system.mapper.produce.MProductPartPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.MProductPartProcessPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.VProductPartPlanMapper;
import com.mcpms.mcpms.system.pojo.base.*;
import com.mcpms.mcpms.system.pojo.produce.*;
import com.mcpms.mcpms.system.service.base.MPartProcessService;
import com.mcpms.mcpms.system.service.base.MProductPartService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 产品零件管理
 * @author yuhong
 * @date   2019/1/16
 **/
@Service
@Transactional
public class MProductPartServiceImpl implements MProductPartService {

    @Autowired
    private VProductPartMapper vProductPartMapper;
    @Autowired
    private MProductPartMapper mProductPartMapper;
    @Autowired
    private MProductPartCustomMapper mProductPartCustomMapper;
    @Autowired
    VProductPartPlanMapper vProductPartPlanMapper;

    @Override
    public Result findpartsbyproductid(MPart mPart, int page, int size, long id) {
        List<VProductPart> list;
        VProductPartExample vProductPartExample = new VProductPartExample();
        VProductPartExample.Criteria criteria = vProductPartExample.createCriteria();
        criteria.andProductIdEqualTo(id);
        if(StringUtils.isEmpty(mPart.getName()) & StringUtils.isEmpty(mPart.getPartNum())){

        }else{

            if(!StringUtils.isEmpty(mPart.getName())){
                criteria.andNameLike("%"+mPart.getName()+"%");
            }
            if(!StringUtils.isEmpty(mPart.getPartNum())){
                criteria.andPartNumLike("%"+mPart.getPartNum()+"%");
            }

        }

        PageHelper.startPage(page, size);
        list = vProductPartMapper.selectByExample(vProductPartExample);
        PageInfo<VProductPart> pageInfo=new PageInfo<VProductPart>(list);

        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Result findnumbypartid(long id) {

        MProductPart mProductPart = mProductPartMapper.selectByPrimaryKey(id);
        if(mProductPart!=null){
            return ResponseUtils.responseSuccess(mProductPart);
        }
        return ResponseUtils.responseFail(ResponseInfo.UNKOWNERROR);

    }

    @Override
    public Result savepartsnum(long id, int num) {
        MProductPart mProductPart = mProductPartMapper.selectByPrimaryKey(id);
        if(mProductPart!=null){
            mProductPart.setNum(num);
            mProductPartMapper.updateByPrimaryKey(mProductPart);
            return ResponseUtils.responseSuccess();
        }
        return ResponseUtils.responseFail(ResponseInfo.UNKOWNERROR);
    }

    @Override
    public Result deleteproductpartsbatch(long[] ids) {

        if(ids.length == 0){
            return ResponseUtils.responseFail(ResponseInfo.LIEASTONE);
        }

        int successdeldata = 0;
        int faildeletedata = 0;
        for(int i=0;i<ids.length;i++){
            MProductPart MProductPart = mProductPartMapper.selectByPrimaryKey(ids[i]);
            if(MProductPart!=null){

                VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
                VProductPartPlanExample.Criteria criteria = vProductPartPlanExample.createCriteria();
                criteria.andPartIdEqualTo(MProductPart.getPartId()).andProductIdEqualTo(MProductPart.getProductId());
                List<VProductPartPlan> vProductPartPlans = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
                if(vProductPartPlans.size() == 0){
                    mProductPartMapper.deleteByPrimaryKey(ids[i]);
                    successdeldata++;
                }else{
                    faildeletedata++;
                }

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
            return ResponseUtils.responseSuccess("删除"+successdeldata+"条记录;"+" 失败"+faildeletedata+"条记录。");
        }
    }

    @Override
    public Result getallnochoiceparts(int page, int size, long id, String name) {

        List<MPart> list;
        PageHelper.startPage(page, size);
        if(name.equals("null") || name.equals("")){
            list = mProductPartCustomMapper.getallnochoiceparts(id);
        }else{

            list = mProductPartCustomMapper.getallnochoicepartsSearch(id,name);
        }
        PageInfo<MPart> pageInfo=new PageInfo<MPart>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Result batchaddparts(long id, long[] ids) {

        if(ids.length == 0){
            return ResponseUtils.responseFail(ResponseInfo.LIEASTONE);
        }

        int successdeldata = 0;
        int faildeletedata = 0;
        for(int i=0;i<ids.length;i++){

            MProductPartExample mProductPartExample = new MProductPartExample();
            MProductPartExample.Criteria criteria = mProductPartExample.createCriteria();
            criteria.andPartIdEqualTo(ids[i]).andProductIdEqualTo(id);

            List<MProductPart> list = mProductPartMapper.selectByExample(mProductPartExample);

            if(list.size() == 0){
                MProductPart mProductPart = new MProductPart();
                mProductPart.setId(IDUtils.genItemId());
                mProductPart.setPartId(ids[i]);
                mProductPart.setProductId(id);
                mProductPart.setNum(1);
                mProductPartMapper.insert(mProductPart);
                successdeldata++;
            }else{
                faildeletedata++;
            }
        }
        if(ids.length == 1){
            if(successdeldata == 1){
                return ResponseUtils.responseSuccess();
            }else{
                return ResponseUtils.responseFail(ResponseInfo.CANNOTADD);
            }
        }else{
            return ResponseUtils.responseSuccess("添加了"+successdeldata+"条记录;"+" 失败"+faildeletedata+"条记录。");
        }
    }
}
