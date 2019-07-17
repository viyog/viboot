package indi.viyoung.viboot.mail.controller;


import indi.viyoung.viboot.mail.entity.Mail;
import indi.viyoung.viboot.mail.util.MailUtil;

import indi.viyoung.viboot.util.MailConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("mail")
public class MailController {

    @Value("${spring.mail.username}")
    private static String MAIL_SENDER;

    @PostMapping("mail-test")
    public void simpleMailTest(@RequestBody Mail email) {
        Mail mail = new Mail();
//        在这里进行邮件发送类型的控制
        mail.setType(MailConstants.SIMPLE_TYPE);
//        这里可以直接读取配置文件中的邮件地址
        mail.setFrom(MAIL_SENDER);
        mail.setTo(email.getTo());
        if (!StringUtils.isEmpty(email.getVariables())) {
            mail.setVariables(email.getVariables());
        }
//        剩余的内容可以根据自己的情况进行填写
        MailUtil.sendEmail(mail);
    }

}
