package indi.viyoung.viboot.exception.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ViBootExceptionAnnotationApplication
 * @Description 全局异常处理注解方式启动类
 * @Author vi
 * @Date 2018/12/18 11:17 AM
 */
@SpringBootApplication
@MapperScan(value = "indi.viyoung.viboot.exception.annotation.dao")
public class ViBootExceptionAnnotationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViBootExceptionAnnotationApplication.class, args);
    }
}
