package indi.viyoung.viboot.mybatis.controller;

import indi.viyoung.viboot.mybatis.entity.UserDO;
import indi.viyoung.viboot.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
