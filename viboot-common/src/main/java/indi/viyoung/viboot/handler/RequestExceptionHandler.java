package indi.viyoung.viboot.handler;

import indi.viyoung.viboot.util.ReturnCode;
import indi.viyoung.viboot.util.ReturnVO;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求路径有误
 * @author yangwei
 * @since 2019-01-02 18:13
 */
@RestController
public class RequestExceptionHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ReturnVO errorPage(){
        return new ReturnVO(ReturnCode.UrlError);
    }
}
