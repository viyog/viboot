package indi.viyoung.viboot.mybatis.controller;


import indi.viyoung.viboot.exception.NullResponseException;
import indi.viyoung.viboot.mybatis.entity.User;
import indi.viyoung.viboot.mybatis.service.UserService;
import indi.viyoung.viboot.util.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author viyoung
 * @since 2018-12-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public Object findAll(){
        return userService.list();
    }


    @RequestMapping("/findByUserName")
    public Object findByUserName(String userName) {
        return userService.findByUserName(userName);

    }

    @RequestMapping("/findAllByPage")
    public Object findAllByPage(){
        throw new RuntimeException("ddd");
    }

    @RequestMapping("/test")
    public ReturnVO test(){
        throw new NullResponseException();
    }

    @PostMapping("/post")
    public Object post(User user) {
        System.out.println(user);
        return userService.list();
    }
}
