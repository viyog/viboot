package indi.viyoung.viboot.exception.annotation.controller;

import indi.viyoung.viboot.exception.annotation.entity.UserDO;
import indi.viyoung.viboot.exception.annotation.service.IUserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制层
 * @author yangwei
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/findAll")
    public List<UserDO> findAll() {
        Integer a = 1/0;
        System.out.println(a);
        return userService.findAll();
    }
}
