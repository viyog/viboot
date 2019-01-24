package indi.viyoung.viboot.resteasy.service.impl;

import indi.viyoung.viboot.resteasy.entity.User;
import indi.viyoung.viboot.resteasy.mapper.UserMapper;
import indi.viyoung.viboot.resteasy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author viyoung
 * @since 2019-01-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
