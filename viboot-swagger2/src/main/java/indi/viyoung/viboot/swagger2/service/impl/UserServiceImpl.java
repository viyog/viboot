package indi.viyoung.viboot.swagger2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import indi.viyoung.viboot.swagger2.entity.User;
import indi.viyoung.viboot.swagger2.mapper.UserMapper;
import indi.viyoung.viboot.swagger2.service.UserService;
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
