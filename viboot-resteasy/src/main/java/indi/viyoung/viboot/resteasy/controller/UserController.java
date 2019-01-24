package indi.viyoung.viboot.resteasy.controller;

import indi.viyoung.viboot.resteasy.entity.User;
import indi.viyoung.viboot.resteasy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author viyoung
 * @since 2019-01-23
 */
@Slf4j
@Path("/users")
@CrossOrigin
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Autowired
    private UserService userService;

    @GET
    public List<User> get() {
        log.info("GET方法执行。。。");
        return userService.list();
    }

    @GET
    @Path("/{id}")
    public User get(@PathVariable String id) {
        log.info("GET..{}...方法执行。。。",id);
        return userService.getById(id);
    }

    @POST
    public void post() {
        log.info("POST方法执行。。。");
    }

    @PUT
    public void put() {
        log.info("PUT方法执行。。。");
    }

    @DELETE
    public void delete() {
        log.info("DELETE方法执行。。。");
    }
}
