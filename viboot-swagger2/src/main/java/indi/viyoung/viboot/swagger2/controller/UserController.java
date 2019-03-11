package indi.viyoung.viboot.swagger2.controller;

import indi.viyoung.viboot.swagger2.entity.User;
import indi.viyoung.viboot.swagger2.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
@CrossOrigin
@Api(tags = "用户类控制器")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    @ApiResponse(response = User.class,code = 200,message = "查询成功")
    public List<User> get() {
        log.info("GET方法执行。。。");
        return userService.list();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    public User get(@PathVariable Long id) {
        log.info("GET..{}...方法执行。。。",id);
        return userService.getById(id);
    }

    @PostMapping
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "user类", required = true, dataType = "User")
    public void post(@RequestBody User user) {
        userService.save(user);
        log.info("POST方法执行。。。");
    }

    @PutMapping
    @ApiOperation(value="更新用户信息",notes = "根据User对象更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    public void put(User user) {
        userService.updateById(user);
        log.info("PUT方法执行。。。");
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    public void delete(@PathVariable Long id) {
        userService.removeById(id);
        log.info("DELETE方法执行。。。");
    }
}
