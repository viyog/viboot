package indi.viyoung.viboot.uploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author vi
 * @since 2019/4/16 9:39 PM
 */
@SpringBootApplication
@ComponentScan("indi.viyoung")
public class ViBootUploaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViBootUploaderApplication.class,args);
    }
}
