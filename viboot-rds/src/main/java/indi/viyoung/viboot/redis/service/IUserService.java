package indi.viyoung.viboot.redis.service;

import indi.viyoung.viboot.redis.entity.UserDO;

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

    UserDO findOne(Long id);

    int delete(Long id);

    UserDO update(UserDO userDO);
}
