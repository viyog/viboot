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
@MapperScan(basePackages = "indi.viyoung.viboot.indi.viyoung.viboot.mybatis.dao", sqlSessionTemplateRef = "sqlSessionTemplate")
public class ViBootMybatisGraceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViBootMybatisGraceApplication.class, args);
    }
}
