package indi.viyoung.viboot.mybatis.service;

import indi.viyoung.viboot.mybatis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author viyoung
 * @since 2018-12-20
 */
public interface UserService extends IService<User> {

    /**
     * 通过姓名查询人员
     * @return
     */
    User findByUserName(String userName);
}
