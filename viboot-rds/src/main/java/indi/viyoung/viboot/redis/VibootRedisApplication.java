package indi.viyoung.viboot.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author vi
 * @since 2019/3/20 10:51 PM
 */
@SpringBootApplication
@MapperScan(value = "indi.viyoung.viboot.redis.mapper")
@EnableCaching
public class VibootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(VibootRedisApplication.class, args);
    }
}
