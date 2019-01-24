package indi.viyoung.viboot.aop;

import indi.viyoung.viboot.handler.GlobalExceptionHandler;

import indi.viyoung.viboot.util.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 统一封装返回值和异常处理
 *
 * @author vi
 * @since 2018/12/20 6:09 AM
 */
@Aspect
@Order(5)
@Component
@Slf4j
public class ResponseAop {

    @Autowired
    private GlobalExceptionHandler exceptionHandler;


    /**
     * 切点
     */
    @Pointcut("execution(public * indi.viyoung.viboot.*.controller..*(..))")
    public void httpResponse() {
    }

    /**
     * 环切
     */
    @Around("httpResponse()")
    public ReturnVO handlerController(ProceedingJoinPoint proceedingJoinPoint) {
        ReturnVO returnVO = new ReturnVO();
        try {
            Object proceed = proceedingJoinPoint.proceed();
            log.info("xx");
            if (proceed instanceof ReturnVO) {
                returnVO = (ReturnVO) proceed;
            } else {
                returnVO.setData(proceed);
            }
        }  catch (Throwable throwable) {
            // 这里直接调用刚刚我们在handler中编写的方法
            returnVO =  exceptionHandler.handlerException(throwable);
        }
        return returnVO;
    }
}
