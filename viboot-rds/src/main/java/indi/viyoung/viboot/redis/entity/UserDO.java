package indi.viyoung.viboot.redis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserDO
 * @Description TODO
 * @Author vi
 * @Date 2018/12/12 10:30 PM
 */
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = -2910356307341008947L;

    private Long id;

    private String username;

    private String password;

}
