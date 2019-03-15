package indi.viyoung.viboot.pagehelper.service.impl;


import indi.viyoung.viboot.pagehelper.entity.UserDO;
import indi.viyoung.viboot.pagehelper.mapper.UserMapper;
import indi.viyoung.viboot.pagehelper.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author vi
 * @Date 2018/12/13 9:29 AM
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDO> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<UserDO> findPage(HttpServletRequest parameterMap) {
        return userMapper.findPage(parameterMap);
    }
}
