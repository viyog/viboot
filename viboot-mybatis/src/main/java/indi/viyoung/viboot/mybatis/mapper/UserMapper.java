package indi.viyoung.viboot.mybatis.mapper;

import indi.viyoung.viboot.mybatis.entity.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yangwei
 */
public interface UserMapper {

    /**
     * 查询所有信息
     * @return 人员列表
     */
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "password", column = "password")
    })
    List<UserDO> findAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "password", column = "password")
    })
    UserDO get(Long id);

    @Insert("INSERT INTO user(user_name,password) VALUES(#{userName}, #{password})")
    void insert(UserDO user);

    @Update("UPDATE user SET user_name=#{userName},password=#{password} WHERE id =#{id}")
    void update(UserDO user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
}
