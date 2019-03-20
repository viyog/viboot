package indi.viyoung.viboot.redis.mapper;

import indi.viyoung.viboot.redis.entity.UserDO;

import java.util.List;

public interface UserMapper {

    List<UserDO> findAll();

    UserDO get(Long id);

    Integer insert(UserDO user);

    int update(UserDO user);

    int delete(Long id);
}
