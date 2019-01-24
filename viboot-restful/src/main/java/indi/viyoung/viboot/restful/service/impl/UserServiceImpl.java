package indi.viyoung.viboot.restful.service.impl;

import indi.viyoung.viboot.restful.entity.User;
import indi.viyoung.viboot.restful.mapper.UserMapper;
import indi.viyoung.viboot.restful.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author viyoung
 * @since 2019-01-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
