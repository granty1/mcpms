package com.mcpms.mcpms.system.service.produce.impl;

import com.mcpms.mcpms.response.ResponseInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.base.*;
import com.mcpms.mcpms.system.mapper.out.MProductPartOutprocessMapper;
import com.mcpms.mcpms.system.mapper.produce.*;
import com.mcpms.mcpms.system.pojo.base.*;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.out.MProductPartOutprocess;
import com.mcpms.mcpms.system.pojo.produce.*;
import com.mcpms.mcpms.system.service.produce.MOrderProductService;
import com.mcpms.mcpms.system.service.produce.MOrderService;
import com.mcpms.mcpms.system.utils.IDUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单产品管理
 *
 * @author yuhong
 * @date 2019/1/16
 **/
@Service
@Transactional
public class MOrderProductServiceImpl implements MOrderProductService {

    private static final String CURRENT_USER = "current_user";

    @Autowired
    VOrderProductMapper vOrderProductMapper;
    @Autowired
    MOrderProductMapper mOrderProductMapper;
    @Autowired
    MProductMapper mProductMapper;
    @Autowired
    MOrderProductPartMapper mOrderProductPartMapper;
    @Autowired
    MProductPartMapper mProductPartMapper;
    @Autowired
    MProductPartPlanMapper mProductPartPlanMapper;
    @Autowired
    VProductPartPlanMapper vProductPartPlanMapper;
    @Autowired
    MProductPartProcessPlanMapper mProductPartProcessPlanMapper;
    @Autowired
    MPartProcessMapper mPartProcessMapper;
    @Autowired
    MOrderMapper mOrderMapper;
    @Autowired
    MProductPartOutprocessMapper mProductPartOutprocessMapper;
    @Autowired
    MOutMapper mOutMapper;


    @Override
    public Result getallpro(long id) {
        VOrderProductExample vOrderProductExample = new VOrderProductExample();
        VOrderProductExample.Criteria criteria = vOrderProductExample.createCriteria();
        criteria.andOrderIdEqualTo(id);
        List<VOrderProduct> list = vOrderProductMapper.selectByExample(vOrderProductExample);
        return ResponseUtils.responseSuccess(list);
    }

    @Override
    public Result findonePro(long id) {
        MOrderProduct mOrderProduct = mOrderProductMapper.selectByPrimaryKey(id);
        if (mOrderProduct != null) {
            return ResponseUtils.responseSuccess(mOrderProduct);
        } else {
            return ResponseUtils.responseFail(ResponseInfo.NOTHIS);
        }
    }

    @Override
    public Result update(HttpSession session, MOrderProduct mOrderProduct) {

        if (mOrderProduct.getProductId() == null) {
            return ResponseUtils.responseFail("请选择产品");
        }

        if (mOrderProduct.getNum() == 0) {
            return ResponseUtils.responseFail("请输入数量");
        }
        if (mOrderProduct.getPrice() == null) {
            return ResponseUtils.responseFail("请输入价格");
        }

        MOrderProduct mOrderProductData = mOrderProductMapper.selectByPrimaryKey(mOrderProduct.getId());
        if (mOrderProductData != null) {
            if (!isApprove(mOrderProductData)) {
                return ResponseUtils.responseFail("该订单产品已经有计划正在执行，无法更改！");
            }
            if (mOrderProduct.getProductId().equals(mOrderProductData.getProductId())) {
                //如果没有更改产品
                /*更新订单产品零件表*/

                updateOrderProductPart(mOrderProduct);
                /*更新订单产品零件表*/
                mOrderProductMapper.updateByPrimaryKey(mOrderProduct);
                reloadOrderPrice(mOrderProduct);
                return ResponseUtils.responseSuccess();


            } else {
                //产品被更改了


                MOrderProductExample mOrderProductExample = new MOrderProductExample();
                MOrderProductExample.Criteria criteria = mOrderProductExample.createCriteria();
                criteria.andOrderIdEqualTo(mOrderProduct.getOrderId()).andProductIdEqualTo(mOrderProduct.getProductId());

                List<MOrderProduct> list = mOrderProductMapper.selectByExample(mOrderProductExample);

                if (list.size() == 0) {
                    /*删除订单产品零件表*/
                    deleteOrderProductPart(mOrderProduct);

                    /*更新订单产品表*/
                    mOrderProductMapper.updateByPrimaryKey(mOrderProduct);

                    /*更新订单产品零件表*/
                    try {
                        refrashOrderProductPart(session, mOrderProduct);
                    } catch (Exception e) {
                        return ResponseUtils.responseFail("价格过长");
                    }


                    /*更新订单价格*/
                    reloadOrderPrice(mOrderProduct);

                    return ResponseUtils.responseSuccess();
                } else {
                    return ResponseUtils.responseFail(ResponseInfo.ORDERPRODUCTEXIT);
                }
            }


        } else {
            return ResponseUtils.responseFail(ResponseInfo.NOTHIS);
        }
    }

    @Override
    public Result delete(HttpSession session, long[] ids) {
        if (ids.length == 0) {
            return ResponseUtils.responseFail(ResponseInfo.LIEASTONE);
        }

        int successdeldata = 0;
        int faildeletedata = 0;
        int flag = 0;
        for (int i = 0; i < ids.length; i++) {
            MOrderProduct mOrderProduct = mOrderProductMapper.selectByPrimaryKey(ids[i]);
            if (mOrderProduct != null) {
                if (isApprove(mOrderProduct)) {
                    deleteOrderProductPart(mOrderProduct);
                    mOrderProductMapper.deleteByPrimaryKey(ids[i]);
                    reloadOrderPrice(mOrderProduct);
                    successdeldata++;
                } else {
                    flag = 1;
                    faildeletedata++;
                }

            } else {
                faildeletedata++;
            }

        }
        if (ids.length == 1) {
            if (successdeldata == 1) {
                return ResponseUtils.responseSuccess();
            } else {
                if (flag == 1) {
                    return ResponseUtils.responseFail("该订单产品已经有计划正在执行，无法删除！");
                }
                return ResponseUtils.responseFail(ResponseInfo.CANNOTDEL);
            }
        } else {
            return ResponseUtils.responseSuccess("删除" + successdeldata + "条记录; " + " 失败" + faildeletedata + "条记录。");
        }
    }

    @Override
    public Result add(HttpSession session, MOrderProduct mOrderProduct) {
        if (mOrderProduct.getProductId() == null) {
            return ResponseUtils.responseFail("请选择产品");
        }

        if (mOrderProduct.getNum() == 0) {
            return ResponseUtils.responseFail("请输入数量");
        }
        if (mOrderProduct.getPrice() == null) {
            return ResponseUtils.responseFail("请输入价格");
        }

        MOrderProductExample mOrderProductExample = new MOrderProductExample();
        MOrderProductExample.Criteria criteria = mOrderProductExample.createCriteria();
        criteria.andProductIdEqualTo(mOrderProduct.getProductId());
        criteria.andOrderIdEqualTo(mOrderProduct.getOrderId());
        List<MOrderProduct> list = mOrderProductMapper.selectByExample(mOrderProductExample);

        if (list.size() == 0) {


            mOrderProduct.setId(IDUtils.genItemId());
            mOrderProductMapper.insert(mOrderProduct);
            /*新增订单产品零件表*/
            try {
                refrashOrderProductPart(session, mOrderProduct);
            } catch (Exception e) {
                return ResponseUtils.responseFail("价格输入过长");
            }


            reloadOrderPrice(mOrderProduct);
            return ResponseUtils.responseSuccess();
        } else {
            return ResponseUtils.responseFail(ResponseInfo.ORDERPRODUCTEXIT);
        }

    }

    @Override
    public Result initData() {
        List<MProduct> list = mProductMapper.selectByExample(null);
        Map<String, List> map = new HashMap<>();
        map.put("productDataList", list);
        return ResponseUtils.responseSuccess(map);
    }

    @Override
    public Result clone(HttpSession session, long orderId, long tOrderId, long orderProductId) {

        MOrderProduct mOrderProduct = mOrderProductMapper.selectByPrimaryKey(orderProductId);
        mOrderProduct.setOrderId(orderId);
        MOrderProductExample mOrderProductExample = new MOrderProductExample();
        MOrderProductExample.Criteria criteria = mOrderProductExample.createCriteria();
        criteria.andProductIdEqualTo(mOrderProduct.getProductId());
        criteria.andOrderIdEqualTo(mOrderProduct.getOrderId());
        List<MOrderProduct> list = mOrderProductMapper.selectByExample(mOrderProductExample);

        if (list.size() == 0) {
            mOrderProduct.setId(IDUtils.genItemId());
            mOrderProductMapper.insert(mOrderProduct);
            /*新增订单产品零件表*/
            try {
                refrashOrderProductPart(session, mOrderProduct);
            } catch (Exception e) {
                return ResponseUtils.responseFail("价格过长");
            }


            reloadOrderPrice(mOrderProduct);
            return ResponseUtils.responseSuccess();
        } else {
            return ResponseUtils.responseFail(ResponseInfo.ORDERPRODUCTEXIT);
        }
    }

    //根据订单产品删除订单产品零件表
    public void deleteOrderProductPart(MOrderProduct mOrderProduct) {
        /*!!!! 删除关联的订单产品零件表数据*/
        MOrderProductPartExample mOrderProductPartExample = new MOrderProductPartExample();
        MOrderProductPartExample.Criteria mOrderProductcriteria = mOrderProductPartExample.createCriteria();
        mOrderProductcriteria.andOrderProductIdEqualTo(mOrderProduct.getId());
        List<MOrderProductPart> mOrderProductPartsList = mOrderProductPartMapper.selectByExample(mOrderProductPartExample);
        for (int j = 0; j < mOrderProductPartsList.size(); j++) {
            MOrderProductPart mOrderProductPart = mOrderProductPartsList.get(j);
            /*删除订单临建*/
            mOrderProductPartMapper.deleteByPrimaryKey(mOrderProductPart.getId());
            /*删除生产计划*/
            MProductPartPlanExample mProductPartPlanExample = new MProductPartPlanExample();
            MProductPartPlanExample.Criteria criteria = mProductPartPlanExample.createCriteria();
            criteria.andOrderProductPartIdEqualTo(mOrderProductPart.getId());
            mProductPartPlanMapper.deleteByExample(mProductPartPlanExample);
            /*删除工序计划*/
            MProductPartProcessPlanExample mProductPartProcessPlanExample = new MProductPartProcessPlanExample();
            MProductPartProcessPlanExample.Criteria criteria1 = mProductPartProcessPlanExample.createCriteria();
            criteria1.andOrderProductPartIdEqualTo(mOrderProductPart.getId());
            mProductPartProcessPlanMapper.deleteByExample(mProductPartProcessPlanExample);
        }

    }


    //根据订单产品刷新订单产品零件表
    public void refrashOrderProductPart(HttpSession session, MOrderProduct mOrderProduct) throws Exception {
        MProductPartExample mProductPartExample = new MProductPartExample();
        MProductPartExample.Criteria mProductPartcriteria = mProductPartExample.createCriteria();
        mProductPartcriteria.andProductIdEqualTo(mOrderProduct.getProductId());
        List<MProductPart> mProductPartsList = mProductPartMapper.selectByExample(mProductPartExample);

        for (int i = 0; i < mProductPartsList.size(); i++) {
            MProductPart mProductPart = mProductPartsList.get(i);
            MOrderProductPart mOrderProductPart = new MOrderProductPart();

            //建立订单产品零件
            mOrderProductPart.setId(IDUtils.genItemId());
            mOrderProductPart.setNum(mProductPart.getNum() * mOrderProduct.getNum());
            mOrderProductPart.setPartId(mProductPart.getPartId());
            mOrderProductPart.setRemarks(mOrderProduct.getRemarks());
            mOrderProductPart.setOrderProductId(mOrderProduct.getId());
            mOrderProductPartMapper.insert(mOrderProductPart);

            //建立生产计划
            MProductPartPlan mProductPartPlan = new MProductPartPlan();

            /* 获取当前用户*/
            MUser cUser = (MUser) session.getAttribute(CURRENT_USER);
            if (cUser != null) {
                if (cUser.getName() != null) {
                    mProductPartPlan.setProducer(cUser.getName());

                } else {
                    mProductPartPlan.setProducer(cUser.getUsername());

                }
            }


            /*mProductPartPlan.setBatch();
            mProductPartPlan.setRunningNum();*/
            mProductPartPlan.setId(IDUtils.genItemId());
            mProductPartPlan.setActualNum(0);
            mProductPartPlan.setOrderProductPartId(mOrderProductPart.getId());
            mProductPartPlan.setNum(mOrderProductPart.getNum());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String createTimeme = df.format(new Date());
            mProductPartPlan.setCreateTime(createTimeme);
            mProductPartPlan.setActualNum(0);//初始化设置报废数量为0
            /*mProductPartPlan.setPrice();*/
            /*mProductPartPlan.setModeId();*/
            mProductPartPlan.setIsInsert(62);
            mProductPartPlan.setStatus(11);
            BigDecimal bigDecimal = new BigDecimal(0.00);
            mProductPartPlan.setPrice(bigDecimal);

            /*适应厂方要求，省去审批功能*/
            mProductPartPlan.setApproveStatus(22);
            mProductPartPlanMapper.insert(mProductPartPlan);
            //建立工序计划
            MProductPartProcessPlan mProductPartProcessPlan = new MProductPartProcessPlan();
            //获取订单产品零件的工序列表
            MPartProcessExample mPartProcessExample = new MPartProcessExample();
            MPartProcessExample.Criteria criteria = mPartProcessExample.createCriteria();
            criteria.andPartsIdEqualTo(mProductPart.getPartId());
            List<MPartProcess> mPartProcessesList = mPartProcessMapper.selectByExample(mPartProcessExample);

            for (int m = 0; m < mPartProcessesList.size(); m++) {
                MPartProcess mPartProcess = mPartProcessesList.get(m);
                mProductPartProcessPlan.setId(IDUtils.genItemId());
                mProductPartProcessPlan.setOrderProductPartId(mOrderProductPart.getId());
                mProductPartProcessPlan.setPartProcessId(mPartProcess.getId());
                mProductPartProcessPlan.setModeId(mPartProcess.getModeId());
                mProductPartProcessPlan.setDay(mPartProcess.getDay());
                mProductPartProcessPlan.setDrawingNum(mPartProcess.getDrawingNum());
                mProductPartProcessPlan.setOutId(mPartProcess.getOutId());
                mProductPartProcessPlan.setPrice(mPartProcess.getPrice());
                mProductPartProcessPlan.setStatus(11);

                /*适应厂方要求，省去审批功能*/
                mProductPartProcessPlan.setApproveStatus(22);
                if (mPartProcess.getModeId() != null) {
                    if (mPartProcess.getModeId() == 1) {
                        mProductPartProcessPlan.setApproveStatus(24);
                    } else {

                        /*在外协记录表中添加待出库记录*/
                       /* Long orderProductPartId = mProductPartProcessPlan.getOrderProductPartId(); // 订单产品零件id
                        Long outId = mProductPartProcessPlan.getOutId();
                        MOut mOut = mOutMapper.selectByPrimaryKey(outId);


                        VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
                        VProductPartPlanExample.Criteria criteria1 = vProductPartPlanExample.createCriteria();
                        criteria1.andOrderProductPartIdEqualTo(orderProductPartId);
                        List<VProductPartPlan> vProductPartPlanList = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);

                        VProductPartPlan vProductPartPlan = vProductPartPlanList.get(0);//当前生产计划


                        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                        String now = df1.format(new Date());


                        MProductPartOutprocess mProductPartOutprocess = new MProductPartOutprocess();
                        mProductPartOutprocess.setId(IDUtils.genItemId());

                        mProductPartOutprocess.setOutId(outId);

                        mProductPartOutprocess.setNum(vProductPartPlan.getNum());
                        mProductPartOutprocess.setModeId(mProductPartProcessPlan.getModeId());
                        mProductPartOutprocess.setOrderProductPartId(mProductPartProcessPlan.getOrderProductPartId());
                        mProductPartOutprocess.setPartProcessId(mProductPartProcessPlan.getPartProcessId());
                        mProductPartOutprocess.setPrice(mProductPartProcessPlan.getPrice());
                        mProductPartOutprocess.setStatus(31);

                        mProductPartOutprocessMapper.insert(mProductPartOutprocess);*/

                    }
                }


                mProductPartProcessPlanMapper.insert(mProductPartProcessPlan);
            }
        }
    }
    //根据订单产品更新订单产品零件表

    /**
     * @param mOrderProduct 页面传过来的订单产品对象
     */
    public void updateOrderProductPart(MOrderProduct mOrderProduct) {
        //根据订单产品id获取所有的订单产品零件
        MOrderProductPartExample mOrderProductPartExample = new MOrderProductPartExample();
        MOrderProductPartExample.Criteria mOrderProductcriteria = mOrderProductPartExample.createCriteria();
        mOrderProductcriteria.andOrderProductIdEqualTo(mOrderProduct.getId());
        List<MOrderProductPart> mOrderProductPartsList = mOrderProductPartMapper.selectByExample(mOrderProductPartExample);


        for (MOrderProductPart mOrderProductPart :
                mOrderProductPartsList) {
            //页面传过来的数量*每个产品需要的零件数量
            MOrderProduct mOrderProduct1 = mOrderProductMapper.selectByPrimaryKey(mOrderProductPart.getOrderProductId());

            MProductPartExample example = new MProductPartExample();
            MProductPartExample.Criteria criteria = example.createCriteria();
            criteria.andProductIdEqualTo(mOrderProduct1.getProductId());
            criteria.andPartIdEqualTo(mOrderProductPart.getPartId());
            List<MProductPart> list = mProductPartMapper.selectByExample(example);
            if (list.size() != 1) {

            }
            MProductPart mProductPart = list.get(0);
            mOrderProductPart.setNum(mProductPart.getNum() * mOrderProduct.getNum());
            mOrderProductPart.setId(mOrderProductPart.getId());
            mOrderProductPart.setPartId(mProductPart.getPartId());
            mOrderProductPart.setRemarks(mOrderProduct.getRemarks());
            mOrderProductPart.setOrderProductId(mOrderProduct.getId());
            mOrderProductPartMapper.updateByPrimaryKey(mOrderProductPart);
        }
        /*更新生产计划*/
        VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
        VProductPartPlanExample.Criteria criteria = vProductPartPlanExample.createCriteria();
        criteria.andOrderIdEqualTo(mOrderProduct.getOrderId()).andProductIdEqualTo(mOrderProduct.getProductId());
        List<VProductPartPlan> list = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
        for (int i = 0; i < list.size(); i++) {
            MProductPartPlan mProductPartPlan = new MProductPartPlan();
            /*      mProductPartPlan.setBatch();
            mProductPartPlan.setRunningNum();*/
            mProductPartPlan.setId(list.get(i).getId());
            mProductPartPlan.setOrderProductPartId(list.get(i).getPartId());

            MProductPartExample mProductPartExample = new MProductPartExample();
            MProductPartExample.Criteria criteria1 = mProductPartExample.createCriteria();
            criteria1.andProductIdEqualTo(list.get(i).getProductId()).andPartIdEqualTo(list.get(i).getPartId());
            List<MProductPart> mProductParts = mProductPartMapper.selectByExample(mProductPartExample);
            if (mProductParts.size() != 1) {

            }

            mProductPartPlan.setNum(mProductParts.get(0).getNum() * mOrderProduct.getNum());
            /*mProductPartPlan.setPrice();*/
            /*mProductPartPlan.setModeId();*/
            mProductPartPlan.setIsInsert(list.get(i).getIsInsert());
            mProductPartPlan.setStatus(list.get(i).getStatus());
            mProductPartPlan.setPrice(list.get(i).getPrice());
            mProductPartPlan.setApproveStatus(list.get(i).getApproveStatus());
            mProductPartPlan.setOrderProductPartId(list.get(i).getOrderProductPartId());
            mProductPartPlan.setRunningNum(list.get(i).getRunningNum());
            mProductPartPlan.setPlanTime(list.get(i).getPlanTime());
            mProductPartPlanMapper.updateByPrimaryKey(mProductPartPlan);
        }


    }

    /*判断订单产品下是否有零件生产计划是否已经执行*/
    public Boolean isApprove(MOrderProduct mOrderProduct) {
        VProductPartPlanExample vProductPartPlanExample = new VProductPartPlanExample();
        VProductPartPlanExample.Criteria criteria = vProductPartPlanExample.createCriteria();
        criteria.andOrderIdEqualTo(mOrderProduct.getOrderId()).andProductIdEqualTo(mOrderProduct.getProductId());
        List<VProductPartPlan> list = vProductPartPlanMapper.selectByExample(vProductPartPlanExample);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStatus() == 12) {
                return false;
            }
        }

        return true;

    }

    /*重新计算订单总价*/
    public void reloadOrderPrice(MOrderProduct mOrderProduct) {

        MOrderProductExample mOrderProductExample = new MOrderProductExample();
        MOrderProductExample.Criteria criteria = mOrderProductExample.createCriteria();
        criteria.andOrderIdEqualTo(mOrderProduct.getOrderId());
        List<MOrderProduct> mOrderProducts = mOrderProductMapper.selectByExample(mOrderProductExample);
        BigDecimal sum = new BigDecimal("0.00");
        for (int i = 0; i < mOrderProducts.size(); i++) {
            MOrderProduct mOrderProduct1 = mOrderProducts.get(i);
            BigDecimal bigDecimal = new BigDecimal(mOrderProduct1.getNum());
            BigDecimal multiply = mOrderProduct1.getPrice().multiply(bigDecimal);
            sum = sum.add(multiply);
        }

        MOrder mOrder = mOrderMapper.selectByPrimaryKey(mOrderProduct.getOrderId());
        if (mOrder != null) {
            mOrder.setPrice(sum);
            mOrderMapper.updateByPrimaryKey(mOrder);
        } else {

        }
    }


}
