package com.mcpms.mcpms.system.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mcpms.mcpms.response.PageInfo;
import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.index.MUserMapper;
import com.mcpms.mcpms.system.mapper.index.VUserMapper;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.index.MUserExample;
import com.mcpms.mcpms.system.pojo.index.VUser;
import com.mcpms.mcpms.system.pojo.index.VUserExample;
import com.mcpms.mcpms.system.service.system.UserService;
import com.mcpms.mcpms.system.utils.DateUtils;
import com.mcpms.mcpms.system.utils.IDUtils;
import com.mcpms.mcpms.system.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
*
* @class  UserServiceImpl
* @author guolin
* @date   2019/2/24/024
**/
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final String DEFAULT_PASSWORD = "111111";

    @Autowired
    private VUserMapper vUserMapper;

    @Autowired
    private MUserMapper mUserMapper;

    @Override
    public Result getAll(VUser vUser, Integer page, Integer size) {
        VUserExample example = new VUserExample();
        VUserExample.Criteria criteria = example.createCriteria();

        if(vUser!=null){
            if(!StringUtils.isEmpty(vUser.getUsername())){
                criteria.andUsernameLike("%"+vUser.getUsername()+"%");
            }
            if(!StringUtils.isEmpty(vUser.getName())){
                criteria.andNameLike("%"+vUser.getName()+"%");
            }
            if(!StringUtils.isEmpty(vUser.getRole())){
                criteria.andRoleEqualTo(vUser.getRole());
            }
        }
        PageHelper.startPage(page,size);
        Page<VUser> list = (Page<VUser>) vUserMapper.selectByExample(example);
        return ResponseUtils.responseSuccess(new PageInfo(list.getTotal(),list.getResult()));
    }

    @Override
    public Result findone(long id) {
        return ResponseUtils.responseSuccess(mUserMapper.selectByPrimaryKey(id));
    }

    @Override
    public Result save(MUser mUser) {
        if(StringUtils.isEmpty(mUser.getUsername()) ||
                StringUtils.isEmpty(mUser.getName()) ||
                StringUtils.isEmpty(mUser.getRole())){
            return ResponseUtils.responseFail("请填写完整");
        }

        MUserExample example = new MUserExample();
        MUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(mUser.getUsername());
        List<MUser> mUsers = mUserMapper.selectByExample(example);
        if(mUsers.size()!=0){
            return ResponseUtils.responseFail("该用户名已存在");
        }
        mUser.setId(IDUtils.genItemId());
        mUser.setTime(DateUtils.getTime());
        mUser.setPassword(MD5Utils.MD5(DEFAULT_PASSWORD));
        mUserMapper.insert(mUser);
        return ResponseUtils.responseSuccess();
    }

    @Override
    public Result update(MUser mUser) {

        MUser user = mUserMapper.selectByPrimaryKey(mUser.getId());

        if(user.getUsername().equals(mUser.getUsername())){
            //未改username
            mUserMapper.updateByPrimaryKey(mUser);
            return ResponseUtils.responseSuccess();
        }
        MUserExample example = new MUserExample();
        MUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(mUser.getUsername());
        List<MUser> mUsers = mUserMapper.selectByExample(example);
        if(mUsers.size()!=0){
            return ResponseUtils.responseFail("该用户名已存在");
        }
        mUserMapper.updateByPrimaryKey(mUser);
        return ResponseUtils.responseSuccess();
    }

    @Override
    public Result delpass(long id) {

        MUser user = mUserMapper.selectByPrimaryKey(id);
        user.setPassword(MD5Utils.MD5(DEFAULT_PASSWORD));
        mUserMapper.updateByPrimaryKey(user);
        return ResponseUtils.responseSuccess();
    }
}
