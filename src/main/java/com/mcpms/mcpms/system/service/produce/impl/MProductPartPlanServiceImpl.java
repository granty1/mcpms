package com.mcpms.mcpms.system.service.produce.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.newplan.mapper.produce.NewMPartPlanMapper;
import com.mcpms.mcpms.newplan.mapper.produce.VPartPlanMapper;
import com.mcpms.mcpms.newplan.mapper.produce.VPartPlanProcessMapper;
import com.mcpms.mcpms.newplan.pojo.produce.*;
import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.*;
import com.mcpms.mcpms.system.mapper.out.MProductPartOutprocessMapper;
import com.mcpms.mcpms.system.mapper.produce.*;
import com.mcpms.mcpms.system.pojo.base.*;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.out.MProductPartOutprocess;
import com.mcpms.mcpms.system.pojo.out.MProductPartOutprocessExample;
import com.mcpms.mcpms.system.pojo.produce.*;
import com.mcpms.mcpms.system.service.produce.MProductPartPlanService;
import com.mcpms.mcpms.system.utils.DateUtils;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 生产计划管理
 * @author yuhong
 * @date   2019/1/16
 **/
@Service
@Transactional
public class MProductPartPlanServiceImpl implements MProductPartPlanService {

    private static final String CURRENT_USER = "current_user";

    @Autowired
    MProductPartPlanMapper mProductPartPlanMapper;
    @Autowired
    VProductPartPlanMapper vProductPartPlanMapper;
    @Autowired
    MModeMapper mModeMapper;
    @Autowired
    MOutMapper mOutMapper;
    @Autowired
    MProductMapper mProductMapper;
    @Autowired
    MPartMapper mPartMapper;
    @Autowired
    MOrderMapper mOrderMapper;
    @Autowired
    MOrderProductMapper mOrderProductMapper;
    @Autowired
    MOrderProductPartMapper mOrderProductPartMapper;
    @Autowired
    MProductPartMapper mProductPartMapper;
    @Autowired
    MPartProcessMapper mPartProcessMapper;
    @Autowired
    MProductPartProcessPlanMapper mProductPartProcessPlanMapper;
    @Autowired
    MProductPartCustomMapper mProductPartCustomMapper;
    @Autowired
    VProductPartMapper vProductPartMapper;
    @Autowired
    MProductPartOutprocessMapper mProductPartOutprocessMapper;
    @Autowired
    private VPartPlanMapper vPartPlanMapper;
    @Autowired
    private NewMPartPlanMapper newMPartPlanMapper;
    @Autowired
    private MStatusMapper mStatusMapper;
    @Autowired
    private VPartPlanProcessMapper vPartPlanProcessMapper;

    @Override
    public Result getall(VPartPlan vPartPlan, Integer page, Integer size) {

        MStatus mStatus = mStatusMapper.selectByPrimaryKey(81L);
        Integer days = mStatus.getSort();
        PageHelper.startPage(page,size);

        VPartPlanExample example = new VPartPlanExample();
        VPartPlanExample.Criteria criteria = example.createCriteria();
        if (vPartPlan!=null){
            //零件名称
            if (!StringUtils.isEmpty(vPartPlan.getPartName())){
                criteria.andPartNameLike("%"+vPartPlan.getPartName()+"%");
            }
            //生产批次号
            if (!StringUtils.isEmpty(vPartPlan.getRunNum())){
                criteria.andRunNumLike("%"+vPartPlan.getRunNum()+"%");
            }
            //存货编码
            if (!StringUtils.isEmpty(vPartPlan.getPartNum())){
                criteria.andPartNumLike("%"+vPartPlan.getPartNum()+"%");
            }
            //状态
            if (vPartPlan.getPlanStatus()!=null && !vPartPlan.getPlanStatus().equals("")){
                criteria.andPlanStatusEqualTo(vPartPlan.getPlanStatus());
            }
            //月份
            if (!StringUtils.isEmpty(vPartPlan.getCreateTime())){
                criteria.andCreateTimeLike("%"+vPartPlan.getCreateTime()+"%");
            }
        }
        Page<VPartPlan> vPartPlans = (Page<VPartPlan>) vPartPlanMapper.selectByExample(example);
        List<VPartPlan> result = vPartPlans.getResult();
        for (VPartPlan plan :
                result) {

            Long id = plan.getId();
            VPartPlanProcessExample processExample = new VPartPlanProcessExample();
            VPartPlanProcessExample.Criteria criteria1 = processExample.createCriteria();
            criteria1.andPartPlanIdEqualTo(id);
            List<VPartPlanProcess> vPartPlanProcesses = vPartPlanProcessMapper.selectByExample(processExample);
            plan.setIsWarning(0L);
            for (VPartPlanProcess process :
                    vPartPlanProcesses) {
                if (process.getPlanProcessStatus().equals(12L)){
                    if (!StringUtils.isEmpty(process.getPlanFinishTime())){
                        String currentTime = DateUtils.getTime();
                        String planTime = process.getPlanFinishTime();
                        try{
                            int nsodays = DateUtils.getDatePoor(currentTime, planTime);
                            if (nsodays<=days){
                                plan.setIsWarning(1L);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                            continue;
                        }
                    }
                }
            }
        }
        return ResponseUtils.responseSuccessPage(vPartPlans.getTotal(),result);
    }

    @Override
    public Result findone(long id) {
        return ResponseUtils.responseSuccess(newMPartPlanMapper.selectByPrimaryKey(id));
    }

    @Override
    public Result update(NewMPartPlan newMPartPlan) {

        if (newMPartPlan.getNum()<=0){
            return ResponseUtils.responseFail("计划量不能小于等于零");
        }
        newMPartPlanMapper.updateByPrimaryKey(newMPartPlan);
        return ResponseUtils.responseSuccess();
    }

    @Override
    public Result delete(long[] ids) {
        return null;
    }

    /*插单*/
    @Override
    public Result add(HttpSession session,VProductPartPlan vProductPartPlan) {

        Long productId = vProductPartPlan.getProductId();
        Long partId = vProductPartPlan.getPartId();
        Integer num = vProductPartPlan.getNum();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String now = df.format(new Date());



        if(productId == null || partId==null || num==null){
            return ResponseUtils.responseFail("请将插单信息填写完整");
        }

        /*根据当前年份获取插单订单id*/
        Long orderId = getOrderId();

        if(orderId.equals(-1)){
            return ResponseUtils.responseFail("插单失败！");
        }


        /*建立该订单产品*/
        MOrderProduct mOrderProduct = new MOrderProduct();
        mOrderProduct.setId(IDUtils.genItemId());
        mOrderProduct.setOrderId(orderId);
        mOrderProduct.setProductId(productId);
        mOrderProductMapper.insert(mOrderProduct);

        /*设置订单产品零件*/
        MOrderProductPart mOrderProductPart = new MOrderProductPart();
        mOrderProductPart.setId(IDUtils.genItemId());
        mOrderProductPart.setOrderProductId(mOrderProduct.getId());
        mOrderProductPart.setPartId(partId);
        mOrderProductPartMapper.insert(mOrderProductPart);

        /*新建零件工序计划*/
        MProductPartPlan mProductPartPlan = new MProductPartPlan();

        /* 获取当前用户*/
        MUser cUser =  (MUser)session.getAttribute(CURRENT_USER);
        if(cUser!=null){
            if(cUser.getName()!=null){
                mProductPartPlan.setProducer(cUser.getName());

            }else{
                mProductPartPlan.setProducer(cUser.getUsername());

            }
        }else{
            return ResponseUtils.responseFail("请先登录!");
        }
        mProductPartPlan.setActualNum(0);
        mProductPartPlan.setId(IDUtils.genItemId());
        mProductPartPlan.setCreateTime(now);
        mProductPartPlan.setStatus(11);
        mProductPartPlan.setApproveStatus(22);
        mProductPartPlan.setNum(num);
        mProductPartPlan.setOrderProductPartId(mOrderProductPart.getId());
        mProductPartPlan.setIsInsert(61);
        mProductPartPlanMapper.insert(mProductPartPlan);

        //建立工序计划
        MProductPartProcessPlan mProductPartProcessPlan = new MProductPartProcessPlan();

        //获取订单产品零件的工序列表
        MPartProcessExample mPartProcessExample = new MPartProcessExample();
        MPartProcessExample.Criteria criteria = mPartProcessExample.createCriteria();
        criteria.andPartsIdEqualTo(partId);
        List<MPartProcess> mPartProcessesList = mPartProcessMapper.selectByExample(mPartProcessExample);

        for(int m=0;m<mPartProcessesList.size();m++){
            MPartProcess mPartProcess = mPartProcessesList.get(m);
            mProductPartProcessPlan.setId(IDUtils.genItemId());
            mProductPartProcessPlan.setOrderProductPartId(mOrderProductPart.getId());
            mProductPartProcessPlan.setPartProcessId(mPartProcess.getId());
            mProductPartProcessPlan.setModeId(mPartProcess.getModeId());
            mProductPartProcessPlan.setDay(mPartProcess.getDay());
            mProductPartProcessPlan.setDrawingNum(mPartProcess.getDrawingNum());
            mProductPartProcessPlan.setOutId(mPartProcess.getOutId());
            mProductPartProcessPlan.setStatus(11);
            mProductPartProcessPlan.setPrice(mPartProcess.getPrice());
            mProductPartProcessPlan.setApproveStatus(22);
            if(mPartProcess.getModeId()!=null){
                if(mPartProcess.getModeId() == 1){
                    mProductPartProcessPlan.setApproveStatus(24);
                }else{


                    /*在外协记录表中添加待出库记录*/
                   /* Long orderProductPartId = mProductPartProcessPlan.getOrderProductPartId(); // 订单产品零件id
                    Long outId = mProductPartProcessPlan.getOutId();
                    MOut mOut = mOutMapper.selectByPrimaryKey(outId);


                    VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
                    VProductPartPlanExample.Criteria criteria1 = vProductPartPlanExample.createCriteria();
                    criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
                    List<VProductPartPlan> vProductPartPlanList = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);

                    if(mOut!=null){
                        MProductPartOutprocess mProductPartOutprocess = new MProductPartOutprocess();
                        mProductPartOutprocess.setId(IDUtils.genItemId());

                        mProductPartOutprocess.setOutId(outId);
                        if(mOut.getPerson() != null){
                            mProductPartOutprocess.setLinkman(mOut.getPerson());
                        }
                        if(mOut.getTel() != null){
                            mProductPartOutprocess.setTel(mOut.getTel());
                        }
                        if(mOut.getAddress() !=null){
                            mProductPartOutprocess.setAddress(mOut.getAddress());
                        }
                        mProductPartOutprocess.setNum(vProductPartPlan.getNum());
                        mProductPartOutprocess.setModeId(mProductPartProcessPlan.getModeId());
                        mProductPartOutprocess.setOrderProductPartId(mProductPartProcessPlan.getOrderProductPartId());
                        mProductPartOutprocess.setPartProcessId(mProductPartProcessPlan.getPartProcessId());
                        mProductPartOutprocess.setPrice(mProductPartProcessPlan.getPrice());
                        mProductPartOutprocess.setStatus(31);

                        mProductPartOutprocessMapper.insert(mProductPartOutprocess);
                    }*/


                }
            }
            mProductPartProcessPlanMapper.insert(mProductPartProcessPlan);
        }




        return ResponseUtils.responseSuccess();
    }

    @Override
    public Result getAllApproval(VProductPartPlan vProductPartPlan, Integer page, Integer size) {
        //走第一个接口
        //getall(vProductPartPlan,page,size);
        return null;
    }

    @Override
    public Result approval(HttpSession session, long[] ids) {
        int succ = 0;
        int fail = 0;
        for(int i=0;i<ids.length;i++){
            MProductPartPlan mProductPartPlan = mProductPartPlanMapper.selectByPrimaryKey(ids[i]);
            if(mProductPartPlan!=null){

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String now = df.format(new Date());

                /* 获取当前用户*/
                MUser cUser =  (MUser)session.getAttribute(CURRENT_USER);
                if(cUser!=null){
                    if(cUser.getName()!=null){
                        mProductPartPlan.setApprovePeople(cUser.getName());

                    }else{
                        mProductPartPlan.setApprovePeople(cUser.getUsername());

                    }
                }else{
                    return ResponseUtils.responseFail("请先登录!");
                }
                mProductPartPlan.setApproveTime(now);

                mProductPartPlan.setApproveStatus(22);

                mProductPartPlanMapper.updateByPrimaryKey(mProductPartPlan);
                succ++;
            }else{
                fail++;
            }
        }
        if(succ == 1){
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseSuccess("成功删除"+succ+"条；失败"+fail+"条。");
        }

    }

    @Override
    public Result back(long id) {
        MProductPartPlan mProductPartPlan = mProductPartPlanMapper.selectByPrimaryKey(id);
        if(mProductPartPlan!=null){
            /*MProductPartProcessPlanExample mProductPartProcessPlanExample = new MProductPartProcessPlanExample();
            MProductPartProcessPlanExample.Criteria criteria = mProductPartProcessPlanExample.createCriteria();
            criteria.andApproveStatusEqualTo()*/
            //查看外协加工历史中是否有记录

            MProductPartOutprocessExample mProductPartOutprocessExample = new MProductPartOutprocessExample();
            MProductPartOutprocessExample.Criteria criteria2 = mProductPartOutprocessExample.createCriteria();
            criteria2.andOrderProductPartIdEqualTo(mProductPartPlan.getOrderProductPartId());
            List<MProductPartOutprocess> mProductPartOutprocesses = mProductPartOutprocessMapper.selectByExample(mProductPartOutprocessExample);

            if(mProductPartOutprocesses.size() >0){
                return ResponseUtils.responseFail("该计划下已经有子计划通过审批，无法驳回！");
            }


            mProductPartPlan.setApproveStatus(23);
            mProductPartPlanMapper.updateByPrimaryKey(mProductPartPlan);
            return ResponseUtils.responseSuccess();
        }else{
            return ResponseUtils.responseFail(ResponseInfo.NOTHIS);
        }
    }

    @Override
    public Result initData() {

        List<MMode> modeData = mModeMapper.selectByExample(null);
        List<MOut> outData = mOutMapper.selectByExample(null);
        //List<MProduct> productData = mProductMapper.selectByExample(null);
        List<MPart> partsData = mPartMapper.selectByExample(null);

        Map map = new HashMap();
        map.put("modeData",modeData);
        map.put("outData",outData);
        //map.put("productData",productData);
        map.put("partsData",partsData);

        return ResponseUtils.responseSuccess(map);
    }

    @Override
    public Result getPartByProduct(long id) {
        VProductPartExample vProductPartExample = new VProductPartExample();
        VProductPartExample.Criteria criteria = vProductPartExample.createCriteria();
        criteria.andProductIdEqualTo(id);
        List<VProductPart> vProductParts = vProductPartMapper.selectByExample(vProductPartExample);

        return ResponseUtils.responseSuccess(vProductParts);
    }


    /*获取订单id*/
    public long getOrderId(){
        SimpleDateFormat yeardf = new SimpleDateFormat("yyyy");//设置日期格式
        String nowYear = yeardf.format(new Date());
        MOrderExample mOrderExample = new MOrderExample();
        MOrderExample.Criteria criteria1 = mOrderExample.createCriteria();
        criteria1.andOrderNumEqualTo(nowYear+"插单");
        List<MOrder> mOrders = mOrderMapper.selectByExample(mOrderExample);
        MOrder mOrder;
        long orderId;
        if( mOrders.size()> 1){
            return -1;
        }else if(mOrders.size() == 0){
            MOrder mOrderNew = new MOrder();
            mOrderNew.setId(IDUtils.genItemId());
            mOrderNew.setOrderNum(nowYear+"插单");
            mOrderNew.setName(nowYear+"插单");
            mOrderMapper.insert(mOrderNew);
            orderId = mOrderNew.getId();
            return orderId;
        }else if(mOrders.size() == 1){
            mOrder = mOrders.get(0);
            orderId = mOrder.getId();
            return orderId;
        }else{
            return -1;
        }

    }
}
