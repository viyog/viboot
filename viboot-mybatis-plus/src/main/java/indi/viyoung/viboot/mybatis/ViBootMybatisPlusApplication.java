package indi.viyoung.viboot.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import indi.viyoung.viboot.util.CORSFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yangwei
 */
@SpringBootApplication
@ComponentScan(value = "indi.viyoung.viboot.*")
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

    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean reg = new FilterRegistrationBean();
        CORSFilter filter = new CORSFilter();
        reg.setFilter(filter);
        reg.setOrder(1);
        reg.addUrlPatterns("/*");
        return reg;
    }

}
