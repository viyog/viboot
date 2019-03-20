package indi.viyoung.viboot.redis.controller;

import indi.viyoung.viboot.redis.entity.UserDO;
import indi.viyoung.viboot.redis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 用户实体类
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/findAll")
    public List<UserDO> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "insert")
    public Integer insert(){
        UserDO userDO = new UserDO();
        userDO.setPassword("123456");
        userDO.setUsername("vi-young");
        return userService.insert(userDO);
    }

    @RequestMapping(value = "/{id}")
    public UserDO findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @RequestMapping(value="/update")
    public void update() {
        UserDO userDO = new UserDO();
        userDO.setId(10000002L);
        userDO.setUsername("redis");
        userDO.setPassword("123456");
        userService.update(userDO);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
