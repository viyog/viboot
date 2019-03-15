package indi.viyoung.viboot.pagehelper.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import indi.viyoung.viboot.pagehelper.entity.UserDO;
import indi.viyoung.viboot.pagehelper.service.IUserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 用户控制层
 * @author yangwei
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("/page0")
    public PageInfo<UserDO> findAll() {
        // 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(1, 10);
        return PageInfo.of(userService.findAll());
    }

    @GetMapping("/page1")
    public PageInfo<UserDO> findPage(HttpServletRequest request) {
        PageHelper.startPage(request);
        return PageInfo.of(userService.findAll());
    }

    @GetMapping("/page2")
    public PageInfo<UserDO> findPage2(HttpServletRequest request) {
        return PageInfo.of(userService.findPage(request));
    }

    @GetMapping("/page3")
    public PageInfo<UserDO> findPage3() {
        // 只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.offsetPage(1, 10);
        return PageInfo.of(userService.findAll());
    }

    @GetMapping("/page4")
    public PageInfo<UserDO> findPage4() {
        return PageHelper.startPage(1, 10).doSelectPageInfo(() -> userService.findAll());
    }
}
