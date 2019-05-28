package com.mcpms.mcpms.system.service.produce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.produce.VOrderProductPartMapper;
import com.mcpms.mcpms.system.pojo.produce.VOrderProductPart;
import com.mcpms.mcpms.system.pojo.produce.VOrderProductPartExample;
import com.mcpms.mcpms.system.service.produce.MOrderProductPartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 订单产品零件管理
 * @author yuhong
 * @date   2019/2/24
 **/
@Service
@Transactional
public class MOrderProductPartServiceImpl implements MOrderProductPartService {

    @Autowired
    VOrderProductPartMapper vOrderProductPartMapper;

    public Result getAllByOrderAndProduct(VOrderProductPart vOrderProductPart, Integer page, Integer size){

        List<VOrderProductPart> list;
        PageHelper.startPage(page, size);
        if(vOrderProductPart==null){
            list = vOrderProductPartMapper.selectByExample(null);
        }else{
            if(StringUtils.isEmpty(vOrderProductPart.getOrderNum()) & vOrderProductPart.getProductId()==null){
                list = vOrderProductPartMapper.selectByExample(null);
            }else{

                VOrderProductPartExample vOrderProductPartExample = new VOrderProductPartExample();
                VOrderProductPartExample.Criteria criteria = vOrderProductPartExample.createCriteria();

                if(!StringUtils.isEmpty(vOrderProductPart.getOrderNum())){
                    criteria.andOrderNumLike("%"+vOrderProductPart.getOrderNum()+"%");
                }
                if(vOrderProductPart.getProductId() != null){
                    criteria.andProductIdEqualTo(vOrderProductPart.getProductId());
                }
                list = vOrderProductPartMapper.selectByExample(vOrderProductPartExample);
            }
        }

        PageInfo<VOrderProductPart> pageInfo=new PageInfo<VOrderProductPart>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }
}
