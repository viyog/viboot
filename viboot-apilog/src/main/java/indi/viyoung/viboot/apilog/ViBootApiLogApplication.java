package indi.viyoung.viboot.apilog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author vi
 * @since 2019/2/19 7:43 PM
 */
@SpringBootApplication
@ComponentScan(value = "indi.viyoung.viboot.*")
@MapperScan(value = "indi.viyoung.viboot.apilog.mapper")
public class ViBootApiLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViBootApiLogApplication.class, args);
    }
}
