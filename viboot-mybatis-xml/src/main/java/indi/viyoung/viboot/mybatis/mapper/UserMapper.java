package indi.viyoung.viboot.mybatis.mapper;

import indi.viyoung.viboot.mybatis.entity.UserDO;

import java.util.List;

public interface UserMapper {

    List<UserDO> findAll();

    UserDO get(Long id);

    Integer insert(UserDO user);

    void update(UserDO user);

    void delete(Long id);
}
