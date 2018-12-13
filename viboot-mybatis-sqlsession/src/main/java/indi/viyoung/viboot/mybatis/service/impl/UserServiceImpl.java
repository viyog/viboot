package indi.viyoung.viboot.mybatis.service.impl;

import indi.viyoung.viboot.mybatis.entity.UserDO;
import indi.viyoung.viboot.mybatis.mapper.UserMapper;
import indi.viyoung.viboot.mybatis.service.IUserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<UserDO> findAll() {
        return sqlSession.selectList("indi.viyoung.viboot.mybatis.mapper.UserMapper.findAll");
    }
}
