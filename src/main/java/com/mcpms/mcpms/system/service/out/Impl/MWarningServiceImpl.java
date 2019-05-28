package com.mcpms.mcpms.system.service.out.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.out.MWarningMapper;
import com.mcpms.mcpms.system.mapper.out.VWarningMapper;
import com.mcpms.mcpms.system.pojo.out.MWarning;
import com.mcpms.mcpms.system.pojo.out.VWarning;
import com.mcpms.mcpms.system.pojo.out.VWarningExample;
import com.mcpms.mcpms.system.service.out.MWarningService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MWarningServiceImpl implements MWarningService {

    @Autowired
    MWarningMapper mWarningMapper;
    @Autowired
    VWarningMapper vWarningMapper;

    public Result getAll(VWarning vWarning, int page, int size){
        List<VWarning> list;
        PageHelper.startPage(page, size);
        VWarningExample vOrderExample = new VWarningExample();
        VWarningExample.Criteria criteria = vOrderExample.createCriteria();
        if(vWarning==null){
            list = vWarningMapper.selectByExample(vOrderExample);
        }else{
            if(StringUtils.isEmpty(vWarning.getOrderNum()) & vWarning.getProductId() == null & vWarning.getPartId() == null){
                list = vWarningMapper.selectByExample(vOrderExample);
            }else{


                if(!StringUtils.isEmpty(vWarning.getOrderNum())){
                    criteria.andOrderNumLike("%"+vWarning.getOrderNum()+"%");
                }
                if(vWarning.getProductId() != null){
                    criteria.andProductIdEqualTo(vWarning.getProductId());
                }
                if(vWarning.getPartId() != null){
                    criteria.andPartIdEqualTo(vWarning.getPartId());
                }

                list = vWarningMapper.selectByExample(vOrderExample);
            }
        }

        PageInfo<VWarning> pageInfo=new PageInfo<VWarning>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());

    }


    public Result hastenDelyvery(long id){
        MWarning mWarning = mWarningMapper.selectByPrimaryKey(id);
        if(mWarning !=null){
            Date dt = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String now=sdf.format(dt);
            if(mWarning.getExpeditingNum() == null){
                mWarning.setExpeditingNum(0);
            }
            mWarning.setExpeditingNum(mWarning.getExpeditingNum()+1);
            mWarning.setExpeditingTime(now);
            mWarningMapper.updateByPrimaryKey(mWarning);
            return ResponseUtils.responseSuccess();
        }
        return ResponseUtils.responseFail("催货失败，不存在该记录");

    }
}
