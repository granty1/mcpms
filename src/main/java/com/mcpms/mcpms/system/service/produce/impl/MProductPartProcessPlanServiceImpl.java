package com.mcpms.mcpms.system.service.produce.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcpms.mcpms.newplan.mapper.produce.NewMPartPlanProcessMapper;
import com.mcpms.mcpms.newplan.mapper.produce.VPartPlanProcessMapper;
import com.mcpms.mcpms.newplan.pojo.produce.NewMPartPlanProcess;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlan;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlanProcess;
import com.mcpms.mcpms.newplan.pojo.produce.VPartPlanProcessExample;
import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.MOutMapper;
import com.mcpms.mcpms.system.mapper.out.MProductPartOutprocessMapper;
import com.mcpms.mcpms.system.mapper.produce.MProductPartProcessPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.VProductPartPlanMapper;
import com.mcpms.mcpms.system.mapper.produce.VProductPartProcessPlanMapper;
import com.mcpms.mcpms.system.pojo.base.MOut;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.out.MProductPartOutprocess;
import com.mcpms.mcpms.system.pojo.produce.*;
import com.mcpms.mcpms.system.service.produce.MProductPartProcessPlanService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 零件工序生产计划
 *
 * @author yuhong
 * @date 2019/1/16
 **/
@Service
@Transactional
public class MProductPartProcessPlanServiceImpl implements MProductPartProcessPlanService {

    private static final String CURRENT_USER = "current_user";


    @Autowired
    MProductPartProcessPlanMapper mProductPartProcessPlanMapper;
    @Autowired
    VProductPartProcessPlanMapper vProductPartProcessPlanMapper;
    @Autowired
    MProductPartOutprocessMapper mProductPartOutprocessMapper;
    @Autowired
    MOutMapper mOutMapper;
    @Autowired
    VProductPartPlanMapper vProductPartPlanMapper;
    @Autowired
    private VPartPlanProcessMapper vPartPlanProcessMapper;
    @Autowired
    private NewMPartPlanProcessMapper newMPartPlanProcessMapper;

    @Override
    public Result findonePro(long id) {
        return ResponseUtils.responseSuccess(newMPartPlanProcessMapper.selectByPrimaryKey(id));
    }

    @Override
    public Result getAllPro(long id) {

        VPartPlanProcessExample example = new VPartPlanProcessExample();
        VPartPlanProcessExample.Criteria criteria = example.createCriteria();
        criteria.andPartPlanIdEqualTo(id);
        List<VPartPlanProcess> vPartPlanProcesses = vPartPlanProcessMapper.selectByExample(example);
        return ResponseUtils.responseSuccess(vPartPlanProcesses);
    }

    @Override
    public Result savePro(NewMPartPlanProcess mProductPartProcessPlan) {

        if (mProductPartProcessPlan != null) {

            if (mProductPartProcessPlan.getOutId() == null & mProductPartProcessPlan.getProcessModeId() != 1) {
                return ResponseUtils.responseFail("请选择外协单位（自加工无需选择）");
            }

            newMPartPlanProcessMapper.updateByPrimaryKey(mProductPartProcessPlan);

                /*在外协记录表中添加待出库记录*/
               /* Long orderProductPartId = mProductPartProcessPlan.getOrderProductPartId(); // 订单产品零件id
                Long outId = mProductPartProcessPlan.getOutId();
                MOut mOut = mOutMapper.selectByPrimaryKey(outId);


                VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
                VProductPartPlanExample.Criteria criteria1 = vProductPartPlanExample.createCriteria();
                criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
                List<VProductPartPlan> vProductPartPlanList = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
                      *//*  if(vProductPartPlanList.size() ==0){
                            return ResponseUtils.responseFail("该计划不存在！");
                        }*//*
                VProductPartPlan vProductPartPlan = vProductPartPlanList.get(0);//当前生产计划
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String now = df1.format(new Date());

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
            return ResponseUtils.responseSuccess();
        } else {
            return ResponseUtils.responseFail(ResponseInfo.NOTHIS);
        }
    }

    @Override
    public Result approvalOut(HttpSession session, long id) {
        MProductPartProcessPlan mProductPartProcessPlan = mProductPartProcessPlanMapper.selectByPrimaryKey(id);
        if (mProductPartProcessPlan != null) {
            if (mProductPartProcessPlan.getModeId() != 1) {

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String nowTime = df.format(new Date());

                /* 获取当前用户*/
                MUser cUser = (MUser) session.getAttribute(CURRENT_USER);
                if (cUser != null) {
                    if (cUser.getName() != null) {
                        mProductPartProcessPlan.setApprovePeople(cUser.getName());

                    } else {
                        mProductPartProcessPlan.setApprovePeople(cUser.getUsername());

                    }
                } else {
                    return ResponseUtils.responseFail("请先登录");
                }
                mProductPartProcessPlan.setApproveTime(nowTime);

                Long outId = mProductPartProcessPlan.getOutId();
                MOut mOut = mOutMapper.selectByPrimaryKey(outId);

                if (outId == null) {
                    return ResponseUtils.responseFail("外协单位还未设置，无法通过！");
                }


                mProductPartProcessPlan.setApproveStatus(22);
                mProductPartProcessPlanMapper.updateByPrimaryKey(mProductPartProcessPlan);

                /*在外协记录表中添加待出库记录*/
                Long orderProductPartId = mProductPartProcessPlan.getOrderProductPartId(); // 订单产品零件id

                VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
                VProductPartPlanExample.Criteria criteria1 = vProductPartPlanExample.createCriteria();
                criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
                List<VProductPartPlan> vProductPartPlanList = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
                if (vProductPartPlanList.size() == 0) {
                    return ResponseUtils.responseFail("该计划不存在！");
                }
                VProductPartPlan vProductPartPlan = vProductPartPlanList.get(0);//当前生产计划


                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String now = df1.format(new Date());


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
                mProductPartOutprocess.setStatus(31);

                mProductPartOutprocessMapper.insert(mProductPartOutprocess);


                return ResponseUtils.responseSuccess();
            } else {
                return ResponseUtils.responseFail("自加工的零件工序无需审批");
            }
        } else {
            return ResponseUtils.responseFail(ResponseInfo.NOTHIS);
        }
    }

    @Override
    public Result getAllApprovalProcess(VProductPartProcessPlan vProductPartProcessPlan, Integer page, Integer size) {
        //获取所有通过审批的工序计划（零件）
        List<VProductPartProcessPlan> list;
        PageHelper.startPage(page, size);
        VProductPartProcessPlanExample vProductPartProcessPlanExample = new VProductPartProcessPlanExample();
        VProductPartProcessPlanExample.Criteria criteria = vProductPartProcessPlanExample.createCriteria();
        VProductPartProcessPlanExample.Criteria criteria1 = vProductPartProcessPlanExample.createCriteria();

        if (vProductPartProcessPlan == null) {
            criteria.andApproveStatusEqualTo(22);//已经审批
            criteria.andStatusEqualTo(11);//未开始
            criteria.andPlanApproveStatusEqualTo(22);
            criteria.andPlanStatusNotEqualTo(14);
            criteria1.andApproveStatusEqualTo(24);//无需审批
            criteria1.andStatusEqualTo(11);//未开始
            criteria1.andPlanApproveStatusEqualTo(22);
            criteria1.andPlanStatusNotEqualTo(14);
            vProductPartProcessPlanExample.or(criteria1);

            list = vProductPartProcessPlanMapper.selectByExample(vProductPartProcessPlanExample);
        } else {
            if (StringUtils.isEmpty(vProductPartProcessPlan.getOrderNum()) &
                    vProductPartProcessPlan.getProductId() == null &
                    vProductPartProcessPlan.getPartsId() == null
                    ) {
                criteria.andApproveStatusEqualTo(22);//已经审批
                criteria.andStatusEqualTo(11);//未开始
                criteria.andPlanApproveStatusEqualTo(22);
                criteria.andPlanStatusNotEqualTo(14);
                criteria1.andApproveStatusEqualTo(24);//无需审批
                criteria1.andStatusEqualTo(11);//未开始
                criteria1.andPlanApproveStatusEqualTo(22);
                criteria1.andPlanStatusNotEqualTo(14);
                vProductPartProcessPlanExample.or(criteria1);
                list = vProductPartProcessPlanMapper.selectByExample(vProductPartProcessPlanExample);
            } else {

                criteria.andApproveStatusEqualTo(22);//已经审批
                criteria.andStatusEqualTo(11);//未开始
                criteria.andPlanApproveStatusEqualTo(22);
                criteria.andPlanStatusNotEqualTo(14);
                criteria1.andApproveStatusEqualTo(24);//无需审批
                criteria1.andStatusEqualTo(11);//未开始
                criteria1.andPlanApproveStatusEqualTo(22);
                criteria1.andPlanStatusNotEqualTo(14);

                if (!StringUtils.isEmpty(vProductPartProcessPlan.getOrderNum())) {
                    criteria.andOrderNumLike("%" + vProductPartProcessPlan.getOrderNum() + "%");
                    criteria1.andOrderNumLike("%" + vProductPartProcessPlan.getOrderNum() + "%");
                }
                if (vProductPartProcessPlan.getProductId() != null) {
                    criteria.andProductIdEqualTo(vProductPartProcessPlan.getProductId());
                    criteria1.andProductIdEqualTo(vProductPartProcessPlan.getProductId());
                }
                if (vProductPartProcessPlan.getPartsId() != null) {
                    criteria.andPartsIdEqualTo(vProductPartProcessPlan.getPartsId());
                    criteria1.andPartsIdEqualTo(vProductPartProcessPlan.getPartsId());
                }
                vProductPartProcessPlanExample.or(criteria1);
                list = vProductPartProcessPlanMapper.selectByExample(vProductPartProcessPlanExample);
            }
        }

        PageInfo<VProductPartProcessPlan> pageInfo = new PageInfo<VProductPartProcessPlan>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public Result getAllInProcess(VProductPartProcessPlan vProductPartProcessPlan, Integer page, Integer size) {
        //获取所有需要入库的的零件
        List<VProductPartProcessPlan> list;
        PageHelper.startPage(page, size);
        VProductPartProcessPlanExample vProductPartProcessPlanExample = new VProductPartProcessPlanExample();
        VProductPartProcessPlanExample.Criteria criteria = vProductPartProcessPlanExample.createCriteria();
        /* VProductPartProcessPlanExample.Criteria criteria1 = vProductPartProcessPlanExample.createCriteria();*/
        /* criteria.andApproveStatusEqualTo(22);//已经审批*/
        criteria.andStatusEqualTo(12);//执行

        /*2019-2-27 */
        criteria.andPlanStatusEqualTo(12);//进行中
        criteria.andPlanApproveStatusEqualTo(22);//计划已审
        long st = 41;
        criteria.andRepertoryStatusEqualTo(st); //库存表中在库
        /*     criteria1.andApproveStatusEqualTo(24);//无需审批*/
        /* criteria1.andStatusEqualTo(12);//执行*/
        /*vProductPartProcessPlanExample.or(criteria1);*/
        if (vProductPartProcessPlan == null) {
            list = vProductPartProcessPlanMapper.selectByExample(vProductPartProcessPlanExample);
        } else {
            if (StringUtils.isEmpty(vProductPartProcessPlan.getOrderNum()) &
                    vProductPartProcessPlan.getProductId() == null &
                    vProductPartProcessPlan.getPartsId() == null
                    ) {
                list = vProductPartProcessPlanMapper.selectByExample(vProductPartProcessPlanExample);
            } else {


                if (!StringUtils.isEmpty(vProductPartProcessPlan.getOrderNum())) {
                    criteria.andOrderNumLike("%" + vProductPartProcessPlan.getOrderNum() + "%");
                }
                if (vProductPartProcessPlan.getProductId() != null) {
                    criteria.andProductIdEqualTo(vProductPartProcessPlan.getProductId());
                }
                if (vProductPartProcessPlan.getPartsId() != null) {
                    criteria.andPartsIdEqualTo(vProductPartProcessPlan.getPartsId());
                }
                list = vProductPartProcessPlanMapper.selectByExample(vProductPartProcessPlanExample);
            }
        }

        PageInfo<VProductPartProcessPlan> pageInfo = new PageInfo<VProductPartProcessPlan>(list);
        return ResponseUtils.responseSuccessPage(pageInfo.getTotal(), pageInfo.getList());
    }
}
