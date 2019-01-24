package indi.viyoung.viboot.restful.controller;

import indi.viyoung.viboot.restful.entity.User;
import indi.viyoung.viboot.restful.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> get() {
        log.info("GET方法执行。。。");
        return userService.list();
    }

    @GetMapping(value = "/{id}")
    public User get(@PathVariable String id) {
        log.info("GET..{}...方法执行。。。",id);
        return userService.getById(id);
    }

    @PostMapping
    public void post() {
        log.info("POST方法执行。。。");
    }

    @PutMapping
    public void put() {
        log.info("PUT方法执行。。。");
    }

    @DeleteMapping
    public void delete() {
        log.info("DELETE方法执行。。。");
    }
}
