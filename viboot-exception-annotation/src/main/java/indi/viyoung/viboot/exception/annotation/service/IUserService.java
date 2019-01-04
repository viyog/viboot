package indi.viyoung.viboot.exception.annotation.service;


import indi.viyoung.viboot.exception.annotation.entity.UserDO;

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

    List<UserDO> findAll1();
}
