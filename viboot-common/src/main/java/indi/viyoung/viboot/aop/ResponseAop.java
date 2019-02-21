package indi.viyoung.viboot.aop;

import eu.bitwalker.useragentutils.UserAgent;
import indi.viyoung.viboot.handler.GlobalExceptionHandler;

import indi.viyoung.viboot.util.JSONUtil;
import indi.viyoung.viboot.util.ReturnVO;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.StringTokenizer;


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

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before("httpResponse()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());

        //记录请求的内容

        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        log.info("接口路径：{}" , request.getRequestURL().toString());
        log.info("浏览器：{}", userAgent.getBrowser().toString());
        log.info("浏览器版本：{}",userAgent.getBrowserVersion());
        log.info("操作系统: {}", userAgent.getOperatingSystem().toString());
        log.info("IP : {}" , request.getRemoteAddr());
        log.info("请求类型：{}", request.getMethod());
        log.info("类方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数 : {} " + Arrays.toString(joinPoint.getArgs()));
    }

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
            startTime.set(System.currentTimeMillis());
            Object proceed = proceedingJoinPoint.proceed();
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

    @AfterReturning(returning = "ret" , pointcut = "httpResponse()")
    public void doAfterReturning(Object ret){
        //处理完请求后，返回内容
        log.info("方法返回值：{}" , ret);
        log.info("方法执行时间：{}毫秒", (System.currentTimeMillis() - startTime.get()));
    }

}
