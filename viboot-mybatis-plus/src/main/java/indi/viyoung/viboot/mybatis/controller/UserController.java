package indi.viyoung.viboot.mybatis.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import indi.viyoung.viboot.mybatis.entity.User;
import indi.viyoung.viboot.mybatis.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<User> findAll(){
        return userService.list();
    }

    @RequestMapping("/findByUserName")
    public User findByUserName(String userName) {
        return userService.findByUserName(userName);

    }

    @RequestMapping("/findAllByPage")
    public IPage<User> findAllByPage(){
        Page<User> userIPage = new Page<>(1,10);
        return userService.page(userIPage);
    }
}
