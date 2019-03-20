package indi.viyoung.viboot.redis.service.impl;

import indi.viyoung.viboot.redis.base.RedisDao;
import indi.viyoung.viboot.redis.entity.UserDO;
import indi.viyoung.viboot.redis.mapper.UserMapper;
import indi.viyoung.viboot.redis.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author vi
 * @Date 2018/12/13 9:29 AM
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisDao redisDao;

    @Override

    public List<UserDO> findAll() {

        return userMapper.findAll();
    }

    @Override
    public Integer insert(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    @Cacheable(value = "users", key = "#id")
    public UserDO findOne(Long id) {
        log.info("From MYSQL");
        return userMapper.get(id);
    }

    @Override
    @CachePut(value = "users", key = "#userDO.id")
    public UserDO update(UserDO userDO) {
        if (userMapper.update(userDO) > 0) {
            return userMapper.get(userDO.getId());
        }
        return null;
    }

    @Override
    @CacheEvict(value = "users", key = "#id")
    public int delete(Long id) {
        return userMapper.delete(id);
    }

}
