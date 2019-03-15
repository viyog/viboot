package indi.viyoung.viboot.pagehelper.service;

import indi.viyoung.viboot.pagehelper.entity.UserDO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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

    List<UserDO> findPage(HttpServletRequest request);
}
