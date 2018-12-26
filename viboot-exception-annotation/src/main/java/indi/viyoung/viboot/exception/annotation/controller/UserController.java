package indi.viyoung.viboot.exception.annotation.controller;

import indi.viyoung.viboot.exception.NullResponseException;
import indi.viyoung.viboot.exception.annotation.entity.UserDO;
import indi.viyoung.viboot.exception.annotation.service.IUserService;
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
    public Object findAll() {
        if ( true) {
            int a =  1/0;
            throw new NullResponseException();
        }
        return userService.findAll();
    }


}
