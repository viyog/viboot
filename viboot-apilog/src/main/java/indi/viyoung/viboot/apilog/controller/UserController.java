package indi.viyoung.viboot.apilog.controller;


import indi.viyoung.viboot.apilog.entity.User;
import indi.viyoung.viboot.apilog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author viyoung
 * @since 2019-01-23
 */
@RestController
@RequestMapping("/users")
@Api
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public Object findAll() {
        return userService.list();
    }
}
