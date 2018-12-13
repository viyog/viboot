package indi.viyoung.viboot.mybatis.service;

import indi.viyoung.viboot.mybatis.entity.UserDO;

import java.util.List;

/**
 * 用户事务接口
 * @author yangwei
 */
public interface IUserService {

    /**
     * 查询所有人员
     * @return
     */
    List<UserDO> findAll();

    Integer insert(UserDO userDO);
}
