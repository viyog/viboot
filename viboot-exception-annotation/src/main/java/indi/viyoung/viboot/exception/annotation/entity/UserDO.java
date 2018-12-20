package indi.viyoung.viboot.exception.annotation.entity;

import lombok.Data;

/**
 * @ClassName UserDO
 * @Description TODO
 * @Author vi
 * @Date 2018/12/12 10:30 PM
 */
@Data
public class UserDO {

    private Long id;

    private String userName;

    private String password;

}
