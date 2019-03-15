package indi.viyoung.viboot.pagehelper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vi
 * @since 2019/3/12 8:56 PM
 */
@SpringBootApplication
@MapperScan(value = "indi.viyoung.viboot.pagehelper.mapper")
public class VibootPagehelperApplication {
    public static void main(String[] args) {
        SpringApplication.run(VibootPagehelperApplication.class, args);
    }
}
