package indi.viyoung.viboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ViBootMybatisApplication
 * @Description TODO
 * @Author vi
 * @Date 2018/12/12 10:07 PM
 */
@SpringBootApplication
@MapperScan(value = "indi.viyoung.viboot.indi.viyoung.viboot.mybatis.mapper")
public class ViBootMybatisXmlApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViBootMybatisXmlApplication.class, args);
    }
}
