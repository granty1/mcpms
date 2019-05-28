package com.mcpms.mcpms.system.service.index.impl;

import com.mcpms.mcpms.response.ResponseUtils;
import com.mcpms.mcpms.response.Result;
import com.mcpms.mcpms.system.mapper.index.MUserMapper;
import com.mcpms.mcpms.system.pojo.index.MUser;
import com.mcpms.mcpms.system.pojo.index.MUserExample;
import com.mcpms.mcpms.system.pojo.index.PassObj;
import com.mcpms.mcpms.system.service.index.loginService;
import com.mcpms.mcpms.system.utils.DateUtils;
import com.mcpms.mcpms.system.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class loginServiceImpl implements loginService {

    private static final String CURRENT_USER = "current_user";

    @Autowired
    private MUserMapper mUserMapper;

    @Override
    public Result login(MUser user, HttpSession session) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return ResponseUtils.responseFail("请填写完整");
        }
        MUserExample example = new MUserExample();
        MUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<MUser> mUsers = mUserMapper.selectByExample(example);
        if (mUsers.size() == 0) {
            return ResponseUtils.responseFail("用户名不存在");
        }
        MUser mUser = mUsers.get(0);
        if (mUser.getPassword().equals(MD5Utils.MD5(user.getPassword()))) {
            mUser.setTime(DateUtils.getTime());
            mUserMapper.updateByPrimaryKey(mUser);

            mUser.setPassword(null);
            session.setAttribute(CURRENT_USER, mUser);
            return ResponseUtils.responseSuccess("success", mUser.getRole());

        } else {
            return ResponseUtils.responseFail("密码错误");
        }
    }


    @Override
    public Result saveInfo(long userId, MUser mUser, HttpSession session) {

        MUser user = mUserMapper.selectByPrimaryKey(userId);

        if (user != null) {
            if (user.getUsername().equals(mUser.getUsername())) {
                user.setName(mUser.getName());
                mUserMapper.updateByPrimaryKey(user);
                return ResponseUtils.responseSuccess();
            }
            MUserExample example = new MUserExample();
            MUserExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(mUser.getUsername());
            List<MUser> mUsers = mUserMapper.selectByExample(example);
            if (mUsers.size() == 0) {
                user.setName(mUser.getName());
                user.setUsername(mUser.getUsername());
                mUserMapper.updateByPrimaryKey(user);
                user.setPassword(null);
                session.setAttribute(CURRENT_USER, user);
                return ResponseUtils.responseSuccess();
            } else {
                return ResponseUtils.responseFail("用户名已被占用");
            }
        }
        return ResponseUtils.responseFail("error");
    }

    @Override
    public Result savePass(long id, PassObj passObj) {
        MUser user = mUserMapper.selectByPrimaryKey(id);
        if (user.getPassword().equals(MD5Utils.MD5(passObj.getOldPass()))) {
            if (passObj.getConfigPass().equals(passObj.getNewPass())) {
                user.setPassword(MD5Utils.MD5(passObj.getConfigPass()));
                mUserMapper.updateByPrimaryKey(user);
                return ResponseUtils.responseSuccess();
            } else {
                return ResponseUtils.responseFail("两次输入密码不一致");
            }
        } else {
            return ResponseUtils.responseFail("旧密码输入有误");
        }
    }
}
