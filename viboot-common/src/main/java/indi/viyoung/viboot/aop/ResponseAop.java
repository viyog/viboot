package indi.viyoung.viboot.aop;

import indi.viyoung.viboot.util.ReadPropertiesUtil;
import indi.viyoung.viboot.util.ReturnCode;
import indi.viyoung.viboot.util.ReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 统一封装返回值和异常处理
 *
 * @author vi
 * @since 2018/12/20 6:09 AM
 */
@Slf4j
@Aspect
@Order(5)
@Component
public class ResponseAop {

    private static final Properties properties = ReadPropertiesUtil.getProperties(System.getProperty("user.dir") + "/viboot-common/src/main/resources/response.properties");

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
            if (proceed instanceof ReturnVO) {
                returnVO = (ReturnVO) proceed;
            } else {
                returnVO.setData(proceed);
            }
        }  catch (Throwable throwable) {
            returnVO = handlerException(throwable);
        }
        return returnVO;
    }

    private ReturnVO handlerException(Throwable throwable) {
        ReturnVO returnVO = new ReturnVO();
        String errorName = throwable.toString();
        errorName = errorName.substring(errorName.lastIndexOf(".") + 1);
        returnVO.setMessage(properties.getProperty(ReturnCode.valueOf(errorName).msg()));
        returnVO.setCode(properties.getProperty(ReturnCode.valueOf(errorName).val()));
        return returnVO;
    }
}
