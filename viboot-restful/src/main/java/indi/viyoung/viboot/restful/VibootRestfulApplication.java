package indi.viyoung.viboot.restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vi
 * @since 2019/1/23 9:20 PM
 */
@SpringBootApplication
@MapperScan(value = "indi.viyoung.viboot.restful.mapper")
public class VibootRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(VibootRestfulApplication.class, args);
    }
}
