package indi.viyoung.viboot.exception.annotation.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RequestExceptionHandler
 * @Description 请求错误，即当访问Controller之前的错误，
 * @Author vi
 * @Date 2018/12/18 11:43 AM
 */
@RestController
public class RequestExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
