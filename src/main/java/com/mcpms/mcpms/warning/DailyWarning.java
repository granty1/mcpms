package com.mcpms.mcpms.warning;

import com.mcpms.mcpms.system.mapper.base.MStatusMapper;
import com.mcpms.mcpms.system.mapper.out.MWarningMapper;
import com.mcpms.mcpms.system.mapper.out.VWarningMapper;
import com.mcpms.mcpms.system.mapper.produce.VProductPartProcessPlanMapper;
import com.mcpms.mcpms.system.pojo.base.MStatus;
import com.mcpms.mcpms.system.pojo.out.MWarning;
import com.mcpms.mcpms.system.pojo.out.VWarning;
import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlan;
import com.mcpms.mcpms.system.pojo.produce.VProductPartProcessPlanExample;
import com.mcpms.mcpms.system.utils.DateUtils;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



/**
 * 预警的具体判断实现
 * @author yuhong
 * @date   2019/1/31/031
 **/
@Component
@Transactional
public class DailyWarning {

    private static final Logger log = LoggerFactory.getLogger(DailyWarning.class);

    /**
     * @Autowried
     * ...
     * ...
     */
    @Autowired
    VProductPartProcessPlanMapper vProductPartProcessPlanMapper;
    @Autowired
    MStatusMapper mStatusMapper;
    @Autowired
    MWarningMapper mWarningMapper;
    @Autowired
    VWarningMapper vWarningMapper;


    public void doWarning(){

        /*建立一个MWaring表list*/
        /*List<MWarning> mWaringList = new ArrayList<MWarning>();*/
        /*mWarningMapper.deleteByExample(null);*/
        List<MWarning> mWarningList = mWarningMapper.selectByExample(null);
        List<VWarning> vWarningList = vWarningMapper.selectByExample(null);

        /*获取预警时间*/
        long id = 81;
        MStatus mStatus = mStatusMapper.selectByPrimaryKey(id);
        int warningDay = mStatus.getSort();

        /*获取当前时间*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowTime = df.format(new Date());

        /*查询正在进行中的工序计划*/
        VProductPartProcessPlanExample vProductPartProcessPlanExample = new VProductPartProcessPlanExample();
        VProductPartProcessPlanExample.Criteria criteria = vProductPartProcessPlanExample.createCriteria();
        criteria.andStatusEqualTo(12);
        List<VProductPartProcessPlan> vProductPartProcessPlans = vProductPartProcessPlanMapper.selectByExample(vProductPartProcessPlanExample);

        /*判断之前---先删一遍表(不符合条件)---更新一遍表*/
        for(int j=0;j<vWarningList.size();j++){
            VWarning vWarning = vWarningList.get(j);

            if(!StringUtils.isEmpty(vWarning.getPlanTime())){
                String planTimeW = vWarning.getPlanTime();

                try {
                    int datePoorW = DateUtils.getDatePoor(nowTime,planTimeW);
                    MWarning mWarning = mWarningMapper.selectByPrimaryKey(vWarning.getId());
                    mWarning.setDay(datePoorW);
                    mWarningMapper.updateByPrimaryKey(mWarning);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }


            if(vWarning.getDay()>warningDay){
                mWarningMapper.deleteByPrimaryKey(vWarning.getId());
            }

        }



        for(int i=0;i<vProductPartProcessPlans.size();i++){
            VProductPartProcessPlan vProductPartProcessPlan = vProductPartProcessPlans.get(i);
            Long orderProductPartId = vProductPartProcessPlan.getOrderProductPartId();

            /*如果计划时间为空，那么跳过此次判断*/
            if(StringUtils.isEmpty(vProductPartProcessPlan.getPlanTime())){
                continue;
            }
            String planTime = vProductPartProcessPlan.getPlanTime();


            try {
                int datePoor = DateUtils.getDatePoor(nowTime, planTime);
                if(datePoor<=warningDay){
                    int flag = 0;
                    for(int j=0;j<mWarningList.size();j++){
                        MWarning mWarning = mWarningList.get(j);
                        if(!mWarning.getOrderProductPartId().equals(vProductPartProcessPlan.getOrderProductPartId())){
                            flag++;
                        }
                    }
                    if(flag == mWarningList.size()){
                        MWarning mWarning = new MWarning();
                        mWarning.setExpeditingNum(0);
                        mWarning.setDay(datePoor);
                        mWarning.setId(IDUtils.genItemId());
                        mWarning.setOrderProductPartId(vProductPartProcessPlan.getOrderProductPartId());

                        mWarningMapper.insert(mWarning);
                    }

                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        log.info("***************************************************************");
        log.info("* do outSource Warning Finished$ at time:"+DateUtils.getTime()+"  *");
        log.info("***************************************************************");
    }

}
