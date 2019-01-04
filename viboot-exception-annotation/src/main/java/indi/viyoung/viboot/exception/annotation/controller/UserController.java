package indi.viyoung.viboot.exception.annotation.controller;

import indi.viyoung.viboot.exception.NullResponseException;
import indi.viyoung.viboot.exception.annotation.entity.UserDO;
import indi.viyoung.viboot.exception.annotation.service.IUserService;
import indi.viyoung.viboot.util.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "/findAll")
    public Object findAll() {
        throw new RuntimeException("ddd");
    }

    @RequestMapping(value = "/findAll1")
    public ReturnVO findAll1(UserDO userDO) {
        System.out.println(userDO);
        return new ReturnVO(userService.findAll1());
    }

    @RequestMapping(value = "/test")
    public ReturnVO test() {
        throw new RuntimeException("测试非自定义运行时异常");
    }
}
