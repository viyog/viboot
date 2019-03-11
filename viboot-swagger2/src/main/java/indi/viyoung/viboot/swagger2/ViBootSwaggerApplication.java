package indi.viyoung.viboot.swagger2;

//import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author vi
 * @since 2019/3/6 6:35 PM
 */
@SpringBootApplication
@ComponentScan(value = "indi.viyoung.viboot.*")
@MapperScan(value = "indi.viyoung.viboot.swagger2.mapper")
@EnableSwagger2
//@EnableSwaggerBootstrapUI
public class ViBootSwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ViBootSwaggerApplication.class, args);
    }
}
