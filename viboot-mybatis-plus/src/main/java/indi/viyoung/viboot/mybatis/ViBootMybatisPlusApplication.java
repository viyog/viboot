package indi.viyoung.viboot.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author yangwei
 */
@SpringBootApplication
@MapperScan(value = "indi.viyoung.viboot.mybatis.mapper")
public class ViBootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViBootMybatisPlusApplication.class, args);
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
