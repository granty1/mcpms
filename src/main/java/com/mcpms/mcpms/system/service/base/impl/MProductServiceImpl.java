package com.mcpms.mcpms.system.service.base.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MProcessMapper;
import com.mcpms.mcpms.system.mapper.base.MProductMapper;
import com.mcpms.mcpms.system.mapper.base.MProductPartMapper;
import com.mcpms.mcpms.system.pojo.base.MProduct;
import com.mcpms.mcpms.system.pojo.base.MProductExample;
import com.mcpms.mcpms.system.pojo.base.MProductPart;
import com.mcpms.mcpms.system.pojo.base.MProductPartExample;
import com.mcpms.mcpms.system.service.base.MProductService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品管理
 * @author yuhong
 * @date   2019/1/16
 **/
@Service
@Transactional
public class MProductServiceImpl implements MProductService {
    
    @Autowired
    private MProductMapper mProductMapper;
    @Autowired
    private MProductPartMapper mProductPartMapper;
    
    @Override
    public Result getAll(MProduct mProduct, Integer page, Integer size) {
        List<MProduct> list;
        PageHelper.startPage(page, size);
        if(StringUtils.isEmpty(mProduct.getName()) & StringUtils.isEmpty(mProduct.getType())){
            list = mProductMapper.selectByExample(null);
        }else{
            MProductExample mProductExample = new MProductExample();
            MProductExample.Criteria criteria = mProductExample.createCriteria();

            if(!StringUtils.isEmpty(mProduct.getName())){
                criteria.andNameLike("%"+mProduct.getName()+"%");
            }
            if(!StringUtils.isEmpty(mProduct.getType())){
                criteria.andTypeLike("%"+mProduct.getType()+"%");
            }
            list = mProductMapper.selectByExample(mProductExample);
        }
        PageInfo<MProduct> pageInfo=new PageInfo<MProduct>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Result del(long[] ids) {



        if(ids.length == 0){
            return ResponseUtils.responseFail(ResponseInfo.LIEASTONE);
        }

        int successdeldata = 0;
        int faildeletedata = 0;
        int flag = 0;
        for(int i=0;i<ids.length;i++){
            MProduct MProduct = mProductMapper.selectByPrimaryKey(ids[i]);
            flag = 0;
            if(MProduct!=null){

                MProductPartExample mProductPartExample = new MProductPartExample();
                MProductPartExample.Criteria criteria = mProductPartExample.createCriteria();
                criteria.andProductIdEqualTo(MProduct.getId());
                List<MProductPart> mProductPartsList = mProductPartMapper.selectByExample(mProductPartExample);
                if(mProductPartsList.size()==0){
                    mProductMapper.deleteByPrimaryKey(ids[i]);
                    successdeldata++;
                }else{
                    flag =1;
                    faildeletedata++;
                }

            }else{
                faildeletedata++;
            }

        }
        if(ids.length == 1){
            if(successdeldata == 1){
                if(flag == 1){
                    return ResponseUtils.responseFail(ResponseInfo.CANNOTDEL+",请先删除相关产品零件！");
                }
                return ResponseUtils.responseSuccess();
            }else{
                return ResponseUtils.responseFail(ResponseInfo.CANNOTDEL);
            }
        }else{
            return ResponseUtils.responseSuccess("删除"+successdeldata+"条记录； "+"失败"+faildeletedata+"条记录。");
        }
    }

    @Override
    public Result findOne(long id) {
        MProduct mProduct = mProductMapper.selectByPrimaryKey(id);
        if(mProduct!=null){
            return ResponseUtils.responseSuccess(mProduct);
        }else{
            return ResponseUtils.responseFail(ResponseInfo.PRODUCTNOTEXIST);
        }
    }

    @Override
    public Result update(MProduct mProduct) {
        //型号不能为空
        if(StringUtils.isEmpty(mProduct.getType())){
            return ResponseUtils.responseFail(ResponseInfo.PRODUCTNEEDNUM);
        }

        MProduct mProductData = mProductMapper.selectByPrimaryKey(mProduct.getId());
        if(mProductData!=null){

            if(mProduct.getType().trim().equals(mProductData.getType())){
                mProductMapper.updateByPrimaryKey(mProduct);
                return ResponseUtils.responseSuccess();
            }else{
                MProductExample mProductExample = new MProductExample();
                MProductExample.Criteria criteria = mProductExample.createCriteria();
                criteria.andTypeEqualTo(mProduct.getType());

                List<MProduct> list = mProductMapper.selectByExample(mProductExample);

                if(list.size() == 0){
                    mProductMapper.updateByPrimaryKey(mProduct);
                    return ResponseUtils.responseSuccess();
                }else{
                    return ResponseUtils.responseFail(ResponseInfo.PRODUCTTYPEEXIST);
                }
            }


        }else{
            return ResponseUtils.responseFail(ResponseInfo.PRODUCTNOTEXIST);
        }
    }

    @Override
    public Result add(MProduct mProduct) {
        if(StringUtils.isEmpty(mProduct.getType())){
            return ResponseUtils.responseFail(ResponseInfo.PRODUCTNEEDNUM);
        }

        MProductExample mProductExample = new MProductExample();
        MProductExample.Criteria criteria = mProductExample.createCriteria();
        criteria.andTypeEqualTo(mProduct.getType());

        List<MProduct> list = mProductMapper.selectByExample(mProductExample);

        if(list.size() == 0){
            mProduct.setId(IDUtils.genItemId());
            mProductMapper.insert(mProduct);
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail(ResponseInfo.PRODUCTTYPEEXIST);
        }
    }
}
