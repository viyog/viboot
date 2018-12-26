package indi.viyoung.viboot.exception.annotation.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @author yangwei
 *
 * @RestControllerAdvice 用于全局返回json，如需返回ModelAndView请使用@ControllerAdvice
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e) {
        String msg = e.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "服务器出错";
        }
        return msg;
    }
}
