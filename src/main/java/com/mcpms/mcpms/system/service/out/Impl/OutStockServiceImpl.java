package com.mcpms.mcpms.system.service.out.Impl;

import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MOutMapper;
import com.mcpms.mcpms.system.mapper.base.MPartProcessMapper;
import com.mcpms.mcpms.system.mapper.out.MProductPartOutprocessMapper;
import com.mcpms.mcpms.system.mapper.out.MProductPartRepertoryMapper;
import com.mcpms.mcpms.system.mapper.out.MWarningMapper;
import com.mcpms.mcpms.system.mapper.out.VWarningMapper;
import com.mcpms.mcpms.system.mapper.produce.MProductPartPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.MProductPartProcessPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.VProductPartPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.VProductPartProcessPlanMapper;
import com.mcpms.mcpms.system.pojo.base.MOut;
import com.mcpms.mcpms.system.pojo.base.MPartProcess;
import com.mcpms.mcpms.system.pojo.out.*;
import com.mcpms.mcpms.system.pojo.produce.*;
import com.mcpms.mcpms.system.pojo.vo.InStockVo;
import com.mcpms.mcpms.system.service.out.OutStockService;
import com.mcpms.mcpms.system.utils.DateUtils;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 出入库
 * @author yuhong
 * @date   2019/2/24
 **/
@Service
@Transactional
public class OutStockServiceImpl implements OutStockService {

    @Autowired
    MProductPartOutprocessMapper mProductPartOutprocessMapper;
    @Autowired
    MProductPartRepertoryMapper mProductPartRepertoryMapper;
    @Autowired
    MProductPartPlanMapper mProductPartPlanMapper;
    @Autowired
    MProductPartProcessPlanMapper mProductPartProcessPlanMapper;
    @Autowired
    VProductPartPlanMapper vProductPartPlanMapper;
    @Autowired
    VProductPartProcessPlanMapper vProductPartProcessPlanMapper;
    @Autowired
    MOutMapper mOutMapper;
    @Autowired
    MWarningMapper mWarningMapper;
    @Autowired
    VWarningMapper vWarningMapper;
    @Autowired
    MPartProcessMapper mPartProcessMapper;

    @Override
    public Result outStock(long id) {
        //查询库存表中是否有记录
        MProductPartProcessPlan mProductPartProcessPlan = mProductPartProcessPlanMapper.selectByPrimaryKey(id);
        Long orderProductPartId = mProductPartProcessPlan.getOrderProductPartId(); // 订单产品零件id

        VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
        VProductPartPlanExample.Criteria criteria1 = vProductPartPlanExample.createCriteria();
        criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
        List<VProductPartPlan> vProductPartPlanList = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
        if(vProductPartPlanList.size() ==0){
            return ResponseUtils.responseFail("该计划不存在！");
        }
        VProductPartPlan vProductPartPlan = vProductPartPlanList.get(0);//当前生产计划



        MProductPartRepertoryExample mProductPartRepertoryExample = new MProductPartRepertoryExample();
        MProductPartRepertoryExample.Criteria criteria = mProductPartRepertoryExample.createCriteria();
        criteria.andOrderProductPartIdEqualTo(orderProductPartId);
        List<MProductPartRepertory> mProductPartRepertorieList = mProductPartRepertoryMapper.selectByExample(mProductPartRepertoryExample);
        //如果没有，则说明是第一次该计划零件的出库---将生产计划设置为已经开始---将该工序计划相应零件导入库存表
        if(mProductPartRepertorieList.size() == 0){
            MProductPartRepertory mProductPartRepertory = new MProductPartRepertory();
            mProductPartRepertory.setId(IDUtils.genItemId());
            mProductPartRepertory.setModeId(mProductPartProcessPlan.getModeId());
            mProductPartRepertory.setCinvcode(null);
            mProductPartRepertory.setNum(vProductPartPlan.getNum());
            mProductPartRepertory.setOrderProductPartId(vProductPartPlan.getOrderProductPartId());
            if(mProductPartProcessPlan.getOutId()!=null){
                mProductPartRepertory.setOutId(mProductPartProcessPlan.getOutId());
            }

            mProductPartRepertory.setPartId(vProductPartPlan.getPartId());
            mProductPartRepertory.setPartProcessId(mProductPartProcessPlan.getPartProcessId());
            /*mProductPartRepertory.setPrice();*/
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String reTime = df.format(new Date());
            mProductPartRepertory.setReTime(reTime);
            mProductPartRepertory.setStatus(41);
            mProductPartRepertoryMapper.insert(mProductPartRepertory);

            mProductPartProcessPlan.setOutTime(reTime);
            mProductPartProcessPlan.setStatus(12);
            mProductPartProcessPlanMapper.updateByPrimaryKey(mProductPartProcessPlan);

            MProductPartPlan mProductPartPlan = mProductPartPlanMapper.selectByPrimaryKey(vProductPartPlan.getId());
            mProductPartPlan.setStatus(12);//执行
            mProductPartPlanMapper.updateByPrimaryKey(mProductPartPlan);

            if(mProductPartProcessPlan.getModeId() != 1){
                /*设置外协加工历史记录中的记录*/
               /* MProductPartOutprocessExample mProductPartOutprocessExample = new MProductPartOutprocessExample();
                MProductPartOutprocessExample.Criteria criteria2 = mProductPartOutprocessExample.createCriteria();
                criteria2.andOrderProductPartIdEqualTo(mProductPartRepertory.getOrderProductPartId()).andPartProcessIdEqualTo(mProductPartRepertory.getPartProcessId());
                List<MProductPartOutprocess> mProductPartOutprocesses = mProductPartOutprocessMapper.selectByExample(mProductPartOutprocessExample);
                MProductPartOutprocess mProductPartOutprocess = mProductPartOutprocesses.get(0);
                mProductPartOutprocess.setOutTime(mProductPartProcessPlan.getOutTime());
                mProductPartOutprocess.setStatus(32);
                mProductPartOutprocessMapper.updateByPrimaryKey(mProductPartOutprocess);*/
                Long outId = mProductPartProcessPlan.getOutId();
                MOut mOut = mOutMapper.selectByPrimaryKey(outId);


                /*VProductPartPlanExample vProductPartPlanExample1 = new VProductPartPlanExample();
                VProductPartPlanExample.Criteria criteria2 = vProductPartPlanExample1.createCriteria();
                criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
                List<VProductPartPlan> vProductPartPlanList1 = vProductPartPlanMapper.selectByExample(vProductPartPlanExample1);*/

                if(mOut!=null) {
                    MProductPartOutprocess mProductPartOutprocess = new MProductPartOutprocess();
                    mProductPartOutprocess.setId(IDUtils.genItemId());

                    mProductPartOutprocess.setOutId(outId);
                    if (mOut.getPerson() != null) {
                        mProductPartOutprocess.setLinkman(mOut.getPerson());
                    }
                    if (mOut.getTel() != null) {
                        mProductPartOutprocess.setTel(mOut.getTel());
                    }
                    if (mOut.getAddress() != null) {
                        mProductPartOutprocess.setAddress(mOut.getAddress());
                    }
                    mProductPartOutprocess.setNum(vProductPartPlan.getNum());
                    mProductPartOutprocess.setModeId(mProductPartProcessPlan.getModeId());
                    mProductPartOutprocess.setOrderProductPartId(mProductPartProcessPlan.getOrderProductPartId());
                    mProductPartOutprocess.setPartProcessId(mProductPartProcessPlan.getPartProcessId());
                    mProductPartOutprocess.setPrice(mProductPartProcessPlan.getPrice());
                    mProductPartOutprocess.setStatus(32);
                    System.out.println("外协加入--------------------------------------------------------------");
                    mProductPartOutprocessMapper.insert(mProductPartOutprocess);
                }else{
                    return ResponseUtils.responseFail("该委外加工没有设置外协单位！！！出入库失败");
                }


            }

            return ResponseUtils.responseSuccess();

        }
        //如果有，则说明不是第一次出库，查询该库存的状态是否为在库，在库的话，则可以出库，否则不能出库
        MProductPartRepertory mProductPartRepertory = mProductPartRepertorieList.get(0);
        int status = mProductPartRepertory.getStatus();
        if(status == 43){
            mProductPartRepertory.setStatus(41);
            mProductPartRepertoryMapper.updateByPrimaryKey(mProductPartRepertory);

            mProductPartProcessPlan.setStatus(12);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String reTime = df.format(new Date());
            mProductPartProcessPlan.setOutTime(reTime);

            mProductPartProcessPlanMapper.updateByPrimaryKey(mProductPartProcessPlan);


            if(mProductPartProcessPlan.getModeId() != 1){
                /*设置外协加工历史记录中的记录*/
                /*MProductPartOutprocessExample mProductPartOutprocessExample = new MProductPartOutprocessExample();
                MProductPartOutprocessExample.Criteria criteria2 = mProductPartOutprocessExample.createCriteria();
                criteria2.andOrderProductPartIdEqualTo(mProductPartRepertory.getOrderProductPartId()).andPartProcessIdEqualTo(mProductPartRepertory.getPartProcessId());
                List<MProductPartOutprocess> mProductPartOutprocesses = mProductPartOutprocessMapper.selectByExample(mProductPartOutprocessExample);
                if(mProductPartOutprocesses.size() ==1){
                    MProductPartOutprocess mProductPartOutprocess = mProductPartOutprocesses.get(0);
                    mProductPartOutprocess.setOutTime(mProductPartProcessPlan.getOutTime());
                    mProductPartOutprocess.setStatus(32);
                    mProductPartOutprocessMapper.updateByPrimaryKey(mProductPartOutprocess);
                }else {
                    return ResponseUtils.responseFail("出库失败！");
                }*/
              /*  Long orderProductPartId = mProductPartProcessPlan.getOrderProductPartId(); // 订单产品零件id*/
                Long outId = mProductPartProcessPlan.getOutId();
                MOut mOut = mOutMapper.selectByPrimaryKey(outId);


                /*VProductPartPlanExample vProductPartPlanExample1 = new VProductPartPlanExample();
                VProductPartPlanExample.Criteria criteria2 = vProductPartPlanExample1.createCriteria();
                criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
                List<VProductPartPlan> vProductPartPlanList1 = vProductPartPlanMapper.selectByExample(vProductPartPlanExample1);*/

                if(mOut!=null) {
                    MProductPartOutprocess mProductPartOutprocess = new MProductPartOutprocess();
                    mProductPartOutprocess.setId(IDUtils.genItemId());

                    mProductPartOutprocess.setOutId(outId);
                    if (mOut.getPerson() != null) {
                        mProductPartOutprocess.setLinkman(mOut.getPerson());
                    }
                    if (mOut.getTel() != null) {
                        mProductPartOutprocess.setTel(mOut.getTel());
                    }
                    if (mOut.getAddress() != null) {
                        mProductPartOutprocess.setAddress(mOut.getAddress());
                    }
                    mProductPartOutprocess.setNum(vProductPartPlan.getNum());
                    mProductPartOutprocess.setModeId(mProductPartProcessPlan.getModeId());
                    mProductPartOutprocess.setOrderProductPartId(mProductPartProcessPlan.getOrderProductPartId());
                    mProductPartOutprocess.setPartProcessId(mProductPartProcessPlan.getPartProcessId());
                    mProductPartOutprocess.setPrice(mProductPartProcessPlan.getPrice());
                    mProductPartOutprocess.setStatus(32);

                    System.out.println("外协加入-------------------------------------------------------------");
                    mProductPartOutprocessMapper.insert(mProductPartOutprocess);
                }else{
                    return ResponseUtils.responseFail("该委外加工没有设置外协单位！！！出入库失败");
                }

            }


            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail("该零件已经出库，无法再次出库");
        }


        //出库成功后将该库存设置为送外协，如果是自加工则设置为出库，将工序计划的状态改为执行

    }

    @Override
    public Result inStock(InStockVo inStockVo,long id) {
        /* 计算报废数量和实际入库数量*//*
        if(inStockVo.getActualNum()){

        }*/


        //查询库存表中是否存在该记录
        //查询库存表中该记录是否为出库状态
        //查询库存表中是否有记录
        MProductPartProcessPlan mProductPartProcessPlan = mProductPartProcessPlanMapper.selectByPrimaryKey(id);
        Long orderProductPartId = mProductPartProcessPlan.getOrderProductPartId(); // 订单产品零件id


        //当前所有工序计划
        MProductPartProcessPlanExample mProductPartProcessPlanExample = new MProductPartProcessPlanExample();
        MProductPartProcessPlanExample.Criteria criteria2 = mProductPartProcessPlanExample.createCriteria();
        criteria2.andOrderProductPartIdEqualTo(orderProductPartId);
        List<MProductPartProcessPlan> list = mProductPartProcessPlanMapper.selectByExample(mProductPartProcessPlanExample);

        VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
        VProductPartPlanExample.Criteria criteria1 = vProductPartPlanExample.createCriteria();
        criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
        List<VProductPartPlan> vProductPartPlanList = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
        if(vProductPartPlanList.size() ==0){
            return ResponseUtils.responseFail("该计划不存在！");
        }
        VProductPartPlan vProductPartPlan = vProductPartPlanList.get(0);//当前视图生产计划
        MProductPartPlan mProductPartPlan = mProductPartPlanMapper.selectByPrimaryKey(vProductPartPlan.getId());//当前生产计划
        int actualinstocknum;
        ///!!!!!!!!有问题
        int desNum = inStockVo.getActualNum();
        if(mProductPartPlan.getActualNum()!=null){
            desNum  = mProductPartPlan.getActualNum()+inStockVo.getActualNum();//报废数量
        }
        actualinstocknum =mProductPartPlan.getNum()-desNum;





        MProductPartRepertoryExample mProductPartRepertoryExample = new MProductPartRepertoryExample();
        MProductPartRepertoryExample.Criteria criteria = mProductPartRepertoryExample.createCriteria();
        criteria.andOrderProductPartIdEqualTo(orderProductPartId);
        List<MProductPartRepertory> mProductPartRepertorieList = mProductPartRepertoryMapper.selectByExample(mProductPartRepertoryExample);
        if(mProductPartRepertorieList.size() == 1){
            MProductPartRepertory mProductPartRepertory = mProductPartRepertorieList.get(0);
            if(mProductPartRepertory.getStatus() == 41){

                if(actualinstocknum==0){
                    mProductPartRepertory.setStatus(42);

                    //将生产计划完成
                    mProductPartPlan.setStatus(14);
                    //将该零件的所有工序计划完成
                   /* for (int i = 0; i < list.size(); i++) {
                        MProductPartProcessPlan mProductPartProcessPlan1 = list.get(i);

                    }*/

                }else if(actualinstocknum<0){
                    return ResponseUtils.responseFail("报废量与实际可报废量不符！");
                }else{
                    mProductPartRepertory.setStatus(43);
                }
                mProductPartRepertory.setNum(actualinstocknum);


            }else{
                return ResponseUtils.responseFail("该计划零件已经入库");
            }




            mProductPartProcessPlan.setStatus(13);
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String reTime = df1.format(new Date());
            mProductPartProcessPlan.setInTime(reTime);
            mProductPartProcessPlan.setActualTime(reTime);
            if(!StringUtils.isEmpty(inStockVo.getRemarks())){
                mProductPartProcessPlan.setRemarks(inStockVo.getRemarks());
            }

            try {
                int datePoor = DateUtils.getDatePoor(mProductPartProcessPlan.getOutTime(), mProductPartProcessPlan.getInTime());
                mProductPartProcessPlan.setDay(datePoor);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseUtils.responseFail("异常:"+e.getMessage());
            }
            mProductPartProcessPlanMapper.updateByPrimaryKey(mProductPartProcessPlan);

            /*-----------------------------------------------------*/
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String intime = df.format(new Date());
            mProductPartRepertory.setInTime(intime);
            mProductPartRepertoryMapper.updateByPrimaryKey(mProductPartRepertory);

            if(mProductPartProcessPlan.getModeId() != 1){
                /*设置外协加工历史记录中的记录*/
                MProductPartOutprocessExample mProductPartOutprocessExample = new MProductPartOutprocessExample();
                MProductPartOutprocessExample.Criteria criteria3 = mProductPartOutprocessExample.createCriteria();
                criteria3.andOrderProductPartIdEqualTo(mProductPartProcessPlan.getOrderProductPartId()).andPartProcessIdEqualTo(mProductPartProcessPlan.getPartProcessId());;
                List<MProductPartOutprocess> mProductPartOutprocesses = mProductPartOutprocessMapper.selectByExample(mProductPartOutprocessExample);
                /*for(int i=0;i<mProductPartOutprocesses.size();i++){
                    MProductPartOutprocess mProductPartOutprocess = mProductPartOutprocesses.get(i);
                    mProductPartOutprocess.setDeliverTime(intime);
                    mProductPartOutprocess.setStatus(33);
                    mProductPartOutprocess.setNum(actualinstocknum);
                    mProductPartOutprocessMapper.updateByPrimaryKey(mProductPartOutprocess);
                }*/
                if(mProductPartOutprocesses.size() ==1){
                    MProductPartOutprocess mProductPartOutprocess = mProductPartOutprocesses.get(0);
                    mProductPartOutprocess.setOutTime(mProductPartProcessPlan.getOutTime());
                    mProductPartOutprocess.setStatus(33);
                    mProductPartOutprocessMapper.updateByPrimaryKey(mProductPartOutprocess);
                }else {
                    /*return ResponseUtils.responseFail("入库失败！");*/
                }




            }

            //更新后-前所有工序计划
            MProductPartProcessPlanExample mProductPartProcessPlanExample1 = new MProductPartProcessPlanExample();
            MProductPartProcessPlanExample.Criteria criteriaL = mProductPartProcessPlanExample.createCriteria();
            criteriaL.andOrderProductPartIdEqualTo(orderProductPartId);
            List<MProductPartProcessPlan> list1 = mProductPartProcessPlanMapper.selectByExample(mProductPartProcessPlanExample);


            
            //判断最后一条记录，将生产计划设置为完成
            int count = 0;
            for(int i=0;i<list1.size();i++){
                MProductPartProcessPlan mProductPartProcessPlan1 = list1.get(i);
                if( mProductPartProcessPlan1.getStatus() == 13){
                    count++;
                }
            }
            int size = list.size();
            if(count == size){

                mProductPartPlan.setStatus(13);//完成
                mProductPartPlan.setActualTime(reTime);
                mProductPartPlan.setInTime(reTime);

            }
            mProductPartPlan.setActualNum(desNum);
            mProductPartPlanMapper.updateByPrimaryKey(mProductPartPlan);

            //删除预警表中数据
            MWarningExample  mWarningExample = new MWarningExample();
            MWarningExample.Criteria criteria3 = mWarningExample.createCriteria();
            criteria3.andOrderProductPartIdEqualTo(mProductPartProcessPlan.getOrderProductPartId());
            List<MWarning> mWarnings = mWarningMapper.selectByExample(mWarningExample);
            if(mWarnings.size() == 1){
                MWarning mWarning = mWarnings.get(0);
                mWarningMapper.deleteByPrimaryKey(mWarning.getId());
            }

            //设置基础数据中的零件工序经验值。。。
           /* MPartProcess mPartProcess = mPartProcessMapper.selectByPrimaryKey(mProductPartProcessPlan.getPartProcessId());*/
            /*mPartProcess.setPrice(mProductPartProcessPlan.getPrice());*/
            /*mPartProcess.setDay(mProductPartProcessPlan.getDay());*/
            /*mPartProcessMapper.updateByPrimaryKey(mPartProcess);*/

            if(actualinstocknum==0){
                mProductPartPlan.setStatus(14);
                mProductPartPlanMapper.updateByPrimaryKey(mProductPartPlan);
                return ResponseUtils.responseFail("该零件已经全部报废！生产计划提前结束并报废！");
            }else {
                return ResponseUtils.responseSuccess();
            }



        }

        return ResponseUtils.responseFail("库存中没有该记录");
    }

    @Override
    public Result destroy(long id) {
        return null;
    }
}
