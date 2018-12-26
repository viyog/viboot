package indi.viyoung.viboot.exception.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author vi
 * @since 7:05 AM 2018/12/25
 **/
@SpringBootApplication
//@ComponentScan(value = "indi.viyoung.viboot.*")
@MapperScan(value = "indi.viyoung.viboot.exception.annotation.dao")
public class ViBootExceptionAnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViBootExceptionAnnotationApplication.class, args);
    }
}
