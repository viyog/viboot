package indi.viyoung.viboot.resteasy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vi
 * @since 2019/1/24 6:02 PM
 */
@SpringBootApplication
@MapperScan(value = "indi.viyoung.viboot.resteasy.mapper")
public class VibootResteasyApplication {

    public static void main(String[] args) {
        SpringApplication.run(VibootResteasyApplication.class ,args);
    }
}
